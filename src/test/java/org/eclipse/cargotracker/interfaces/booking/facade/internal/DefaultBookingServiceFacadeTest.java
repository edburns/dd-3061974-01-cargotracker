package org.eclipse.cargotracker.interfaces.booking.facade.internal;

import org.eclipse.cargotracker.application.BookingService;
import org.eclipse.cargotracker.domain.model.cargo.Cargo;
import org.eclipse.cargotracker.domain.model.cargo.CargoRepository;
import org.eclipse.cargotracker.domain.model.cargo.Itinerary;
import org.eclipse.cargotracker.domain.model.cargo.TrackingId;
import org.eclipse.cargotracker.domain.model.location.UnLocode;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DefaultBookingServiceFacadeTest {

    private static final long DEADLINE_TIME = 123456789L;

    @Test
    public void changeDeadlineDelegatesToBookingService() throws Exception {
        DefaultBookingServiceFacade facade = new DefaultBookingServiceFacade();
        RecordingBookingService bookingService = new RecordingBookingService();

        facade.setBookingServiceForTest(bookingService);
        facade.setCargoRepositoryForTest(new FailingCargoRepository());

        Date arrivalDeadline = new Date(DEADLINE_TIME);

        facade.changeDeadline("ABC123", arrivalDeadline);

        assertEquals(1, bookingService.changeDeadlineCalls);
        assertEquals(new TrackingId("ABC123"), bookingService.trackingId);
        assertSame(arrivalDeadline, bookingService.arrivalDeadline);
        assertEquals(DEADLINE_TIME, bookingService.arrivalDeadline.getTime());
    }

    private static final class RecordingBookingService implements BookingService {

        private int changeDeadlineCalls;
        private TrackingId trackingId;
        private Date arrivalDeadline;

        @Override
        public TrackingId bookNewCargo(UnLocode origin, UnLocode destination,
                                       Date arrivalDeadline) {
            throw new AssertionError("bookNewCargo should not be called");
        }

        @Override
        public List<Itinerary> requestPossibleRoutesForCargo(TrackingId trackingId) {
            throw new AssertionError("requestPossibleRoutesForCargo should not be called");
        }

        @Override
        public void assignCargoToRoute(Itinerary itinerary, TrackingId trackingId) {
            throw new AssertionError("assignCargoToRoute should not be called");
        }

        @Override
        public void changeDestination(TrackingId trackingId, UnLocode unLocode) {
            throw new AssertionError("changeDestination should not be called");
        }

        @Override
        public void changeDeadline(TrackingId trackingId, Date deadline) {
            changeDeadlineCalls++;
            this.trackingId = trackingId;
            this.arrivalDeadline = deadline;
        }
    }

    private static final class FailingCargoRepository implements CargoRepository {

        @Override
        public Cargo find(TrackingId trackingId) {
            throw new AssertionError("find should not be called");
        }

        @Override
        public List<Cargo> findAll() {
            throw new AssertionError("findAll should not be called");
        }

        @Override
        public void store(Cargo cargo) {
            throw new AssertionError("store should not be called");
        }

        @Override
        public TrackingId nextTrackingId() {
            throw new AssertionError("nextTrackingId should not be called");
        }

        @Override
        public List<TrackingId> getAllTrackingIds() {
            throw new AssertionError("getAllTrackingIds should not be called");
        }
    }
}
