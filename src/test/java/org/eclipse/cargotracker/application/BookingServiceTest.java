package org.eclipse.cargotracker.application;

import org.eclipse.cargotracker.application.internal.DefaultBookingService;
import org.eclipse.cargotracker.application.util.DateUtil;
import org.eclipse.cargotracker.domain.model.location.Location;
import org.eclipse.cargotracker.domain.model.location.LocationRepository;
import org.eclipse.cargotracker.domain.model.location.SampleLocations;
import org.eclipse.cargotracker.domain.model.location.UnLocode;
import org.eclipse.cargotracker.domain.service.RoutingService;
import org.eclipse.cargotracker.infrastructure.persistence.jpa.JpaCargoRepository;
import org.eclipse.cargotracker.infrastructure.persistence.jpa.JpaHandlingEventRepository;
import org.eclipse.cargotracker.infrastructure.persistence.jpa.JpaLocationRepository;
import org.eclipse.cargotracker.infrastructure.persistence.jpa.JpaVoyageRepository;
import org.eclipse.cargotracker.infrastructure.routing.ExternalRoutingService;
import org.eclipse.cargotracker.domain.model.cargo.*;
import org.eclipse.cargotracker.domain.model.handling.*;
import org.eclipse.cargotracker.domain.model.voyage.*;
import org.eclipse.cargotracker.domain.shared.*;

import org.eclipse.pathfinder.api.GraphTraversalService;
import org.eclipse.pathfinder.api.TransitEdge;
import org.eclipse.pathfinder.api.TransitPath;
import org.eclipse.pathfinder.internal.GraphDao;

import org.apache.commons.lang3.time.DateUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.util.*;


/**
 * Application layer integration test covering a number of otherwise fairly
 * trivial components that largely do not wararnt their own tests.
 *
 * @author Reza
 */
@RunWith(Arquillian.class)
public class BookingServiceTest {

    @Inject
    private BookingService bookingService;
    @PersistenceContext
    private EntityManager entityManager;

    private static TrackingId trackingId;
    private static List<Itinerary> candidates;
    private static Date deadline;
    private static Itinerary assigned;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap
                .create(WebArchive.class, "cargo-tracker-test.war")
                // Application layer component directly under test.
                .addClass(BookingService.class)
                // Domain layer components.
                .addClass(TrackingId.class)
                .addClass(UnLocode.class)
                .addClass(Itinerary.class)
                .addClass(Leg.class)
                .addClass(Voyage.class)
                .addClass(VoyageNumber.class)
                .addClass(Schedule.class)
                .addClass(CarrierMovement.class)
                .addClass(Location.class)
                .addClass(HandlingEvent.class)
                .addClass(Cargo.class)
                .addClass(RouteSpecification.class)
                .addClass(AbstractSpecification.class)
                .addClass(Specification.class)
                .addClass(AndSpecification.class)
                .addClass(OrSpecification.class)
                .addClass(NotSpecification.class)
                .addClass(Delivery.class)
                .addClass(TransportStatus.class)
                .addClass(HandlingActivity.class)
                .addClass(RoutingStatus.class)
                .addClass(HandlingHistory.class)
                .addClass(DomainObjectUtils.class)
                .addClass(CargoRepository.class)
                .addClass(LocationRepository.class)
                .addClass(VoyageRepository.class)
                .addClass(HandlingEventRepository.class)
                .addClass(HandlingEventFactory.class)
                .addClass(CannotCreateHandlingEventException.class)
                .addClass(UnknownCargoException.class)
                .addClass(UnknownVoyageException.class)
                .addClass(UnknownLocationException.class)
                .addClass(RoutingService.class)
                // Application layer components
                .addClass(DefaultBookingService.class)
                // Infrastructure layer components.
                .addClass(JpaCargoRepository.class)
                .addClass(JpaVoyageRepository.class)
                .addClass(JpaHandlingEventRepository.class)
                .addClass(JpaLocationRepository.class)
                .addClass(ExternalRoutingService.class)
                // Interface components
                .addClass(TransitPath.class)
                .addClass(TransitEdge.class)
                // Third-party system simulator
                .addClass(GraphTraversalService.class)
                .addClass(GraphDao.class)
                // Sample data.
                .addClass(BookingServiceTestDataGenerator.class)
                .addClass(SampleLocations.class)
                .addClass(SampleVoyages.class)
                .addClass(DateUtil.class)
                .addClass(BookingServiceTestRestConfiguration.class)
                .addAsResource("META-INF/persistence.xml",
                        "META-INF/persistence.xml");

        war.addAsWebInfResource("test-web.xml", "web.xml");

        war.addAsLibraries(
                Maven.resolver().loadPomFromFile("pom.xml")
                        .resolve("org.apache.commons:commons-lang3",
                                "com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider")
                        .withTransitivity().asFile());

        return war;
    }

    @Test
    @InSequence(1)
    public void testRegisterNew() {
        UnLocode fromUnlocode = new UnLocode("USCHI");
        UnLocode toUnlocode = new UnLocode("SESTO");

        deadline = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(deadline);
        calendar.add(Calendar.MONTH, 6); // Six months ahead.
        deadline.setTime(calendar.getTime().getTime());

        trackingId = bookingService.bookNewCargo(fromUnlocode, toUnlocode,
                deadline);

        Cargo cargo = entityManager
                .createNamedQuery("Cargo.findByTrackingId", Cargo.class)
                .setParameter("trackingId", trackingId).getSingleResult();

        assertEquals(SampleLocations.CHICAGO, cargo.getOrigin());
        assertEquals(SampleLocations.STOCKHOLM, cargo.getRouteSpecification()
                .getDestination());
        assertTrue(DateUtils.isSameDay(deadline, cargo.getRouteSpecification()
                .getArrivalDeadline()));
        assertEquals(TransportStatus.NOT_RECEIVED, cargo.getDelivery()
                .getTransportStatus());
        assertEquals(Location.UNKNOWN, cargo.getDelivery()
                .getLastKnownLocation());
        assertEquals(Voyage.NONE, cargo.getDelivery().getCurrentVoyage());
        assertFalse(cargo.getDelivery().isMisdirected());
        assertEquals(Delivery.ETA_UNKOWN, cargo.getDelivery()
                .getEstimatedTimeOfArrival());
        assertEquals(Delivery.NO_ACTIVITY, cargo.getDelivery()
                .getNextExpectedActivity());
        assertFalse(cargo.getDelivery().isUnloadedAtDestination());
        assertEquals(RoutingStatus.NOT_ROUTED, cargo.getDelivery()
                .getRoutingStatus());
        assertEquals(Itinerary.EMPTY_ITINERARY, cargo.getItinerary());
    }

    @Test
    @InSequence(2)
    public void testRouteCandidates() {
        candidates = bookingService.requestPossibleRoutesForCargo(trackingId);

        assertFalse(candidates.isEmpty());
    }

    @Test
    @InSequence(3)
    public void testAssignRoute() {
        assigned = candidates.get(new Random().nextInt(candidates
                .size()));

        bookingService.assignCargoToRoute(assigned, trackingId);

        Cargo cargo = entityManager
                .createNamedQuery("Cargo.findByTrackingId", Cargo.class)
                .setParameter("trackingId", trackingId).getSingleResult();

        assertEquals(assigned, cargo.getItinerary());
        assertEquals(TransportStatus.NOT_RECEIVED, cargo.getDelivery()
                .getTransportStatus());
        assertEquals(Location.UNKNOWN, cargo.getDelivery()
                .getLastKnownLocation());
        assertEquals(Voyage.NONE, cargo.getDelivery().getCurrentVoyage());
        assertFalse(cargo.getDelivery().isMisdirected());
        assertTrue(cargo.getDelivery().getEstimatedTimeOfArrival()
                .before(deadline));
        Assert.assertEquals(HandlingEvent.Type.RECEIVE, cargo.getDelivery()
                .getNextExpectedActivity().getType());
        Assert.assertEquals(SampleLocations.CHICAGO, cargo.getDelivery()
                .getNextExpectedActivity().getLocation());
        Assert.assertEquals(null, cargo.getDelivery().getNextExpectedActivity()
                .getVoyage());
        assertFalse(cargo.getDelivery().isUnloadedAtDestination());
        assertEquals(RoutingStatus.ROUTED, cargo.getDelivery()
                .getRoutingStatus());
    }

    @Test
    @InSequence(4)
    public void testChangeDestination() {
        bookingService.changeDestination(trackingId, new UnLocode("FIHEL"));

        Cargo cargo = entityManager
                .createNamedQuery("Cargo.findByTrackingId", Cargo.class)
                .setParameter("trackingId", trackingId).getSingleResult();

        assertEquals(SampleLocations.CHICAGO, cargo.getOrigin());
        assertEquals(SampleLocations.HELSINKI, cargo.getRouteSpecification()
                .getDestination());
        assertTrue(DateUtils.isSameDay(deadline, cargo.getRouteSpecification()
                .getArrivalDeadline()));
        assertEquals(assigned, cargo.getItinerary());
        assertEquals(TransportStatus.NOT_RECEIVED, cargo.getDelivery()
                .getTransportStatus());
        assertEquals(Location.UNKNOWN, cargo.getDelivery()
                .getLastKnownLocation());
        assertEquals(Voyage.NONE, cargo.getDelivery().getCurrentVoyage());
        assertFalse(cargo.getDelivery().isMisdirected());
        assertEquals(Delivery.ETA_UNKOWN, cargo.getDelivery()
                .getEstimatedTimeOfArrival());
        assertEquals(Delivery.NO_ACTIVITY, cargo.getDelivery()
                .getNextExpectedActivity());
        assertFalse(cargo.getDelivery().isUnloadedAtDestination());
        assertEquals(RoutingStatus.MISROUTED, cargo.getDelivery()
                .getRoutingStatus());
    }

    @Test
    @InSequence(5)
    public void testChangeDeadline() {
        Date newDeadline = DateUtils.addMonths(deadline, 1);
        bookingService.changeDeadline(trackingId, newDeadline);

        Cargo cargo = entityManager
                .createNamedQuery("Cargo.findByTrackingId", Cargo.class)
                .setParameter("trackingId", trackingId).getSingleResult();

        assertEquals(SampleLocations.CHICAGO, cargo.getOrigin());
        assertEquals(SampleLocations.HELSINKI, cargo.getRouteSpecification()
                .getDestination());
        assertTrue(DateUtils.isSameDay(newDeadline, cargo.getRouteSpecification()
                .getArrivalDeadline()));
        assertEquals(assigned, cargo.getItinerary());
        assertEquals(TransportStatus.NOT_RECEIVED, cargo.getDelivery()
                .getTransportStatus());
        assertEquals(Location.UNKNOWN, cargo.getDelivery()
                .getLastKnownLocation());
        assertEquals(Voyage.NONE, cargo.getDelivery().getCurrentVoyage());
        assertFalse(cargo.getDelivery().isMisdirected());
        assertEquals(Delivery.ETA_UNKOWN, cargo.getDelivery()
                .getEstimatedTimeOfArrival());
        assertEquals(Delivery.NO_ACTIVITY, cargo.getDelivery()
                .getNextExpectedActivity());
        assertFalse(cargo.getDelivery().isUnloadedAtDestination());
        assertEquals(RoutingStatus.MISROUTED, cargo.getDelivery()
                .getRoutingStatus());
    }

    @Test
    @InSequence(6)
    public void testChangeDeadlineInvokesAggregateAndStore() throws Exception {
        TrackingId id = new TrackingId("TEST01");
        Date originalDeadline = DateUtils.addMonths(new Date(), 2);
        Date requestedDeadline = DateUtils.addMonths(originalDeadline, 1);
        RouteSpecification originalSpecification = new RouteSpecification(
                SampleLocations.CHICAGO, SampleLocations.HELSINKI, originalDeadline);
        RecordingCargo cargo = new RecordingCargo(id, originalSpecification);

        Date now = new Date();
        Leg leg = new Leg(Voyage.NONE, SampleLocations.CHICAGO,
                SampleLocations.HELSINKI, now, DateUtils.addDays(now, 1));
        Itinerary originalItinerary = new Itinerary(Collections.singletonList(leg));
        cargo.assignToRoute(originalItinerary);
        Delivery deliveryBeforeChange = cargo.getDelivery();

        RecordingCargoRepository cargoRepository = new RecordingCargoRepository(cargo);
        DefaultBookingService service = new DefaultBookingService();
        setField(service, "cargoRepository", cargoRepository);

        service.changeDeadline(id, requestedDeadline);

        assertEquals(1, cargo.specifyNewRouteCalls);
        assertNotNull(cargo.lastSpecifiedRouteSpecification);
        assertNotSame(originalSpecification, cargo.lastSpecifiedRouteSpecification);
        assertEquals(SampleLocations.CHICAGO, cargo.lastSpecifiedRouteSpecification.getOrigin());
        assertEquals(SampleLocations.HELSINKI, cargo.lastSpecifiedRouteSpecification.getDestination());
        assertTrue(DateUtils.isSameDay(requestedDeadline,
                cargo.lastSpecifiedRouteSpecification.getArrivalDeadline()));
        assertEquals(originalItinerary, cargo.getItinerary());
        assertNotSame(deliveryBeforeChange, cargo.getDelivery());
        assertTrue(cargoRepository.storeCalled);
        assertSame(cargo, cargoRepository.storedCargo);
    }

    private static void setField(Object target, String fieldName, Object value)
            throws Exception {
        Field field = DefaultBookingService.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private static final class RecordingCargo extends Cargo {

        private int specifyNewRouteCalls;
        private RouteSpecification lastSpecifiedRouteSpecification;

        private RecordingCargo(TrackingId trackingId,
                               RouteSpecification routeSpecification) {
            super(trackingId, routeSpecification);
        }

        @Override
        public void specifyNewRoute(RouteSpecification routeSpecification) {
            specifyNewRouteCalls++;
            lastSpecifiedRouteSpecification = routeSpecification;
            super.specifyNewRoute(routeSpecification);
        }
    }

    private static final class RecordingCargoRepository implements CargoRepository {

        private final Cargo cargo;
        private boolean storeCalled;
        private Cargo storedCargo;

        private RecordingCargoRepository(Cargo cargo) {
            this.cargo = cargo;
        }

        @Override
        public Cargo find(TrackingId trackingId) {
            return cargo;
        }

        @Override
        public List<Cargo> findAll() {
            return Collections.emptyList();
        }

        @Override
        public void store(Cargo cargo) {
            storeCalled = true;
            storedCargo = cargo;
        }

        @Override
        public TrackingId nextTrackingId() {
            return new TrackingId("NEXT01");
        }

        @Override
        public List<TrackingId> getAllTrackingIds() {
            return Collections.emptyList();
        }
    }
}
