package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.Location;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.RouteCandidate;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class ChangeArrivalDeadlineDateTest {

    @Test
    public void loadRequestsTheCorrectTrackingIdAndParsesTheDeadlineDate()
            throws Exception {
        RecordingBookingServiceFacade facade = new RecordingBookingServiceFacade();
        facade.cargoToReturn = cargoRouteWithDeadlineDate("06/15/2014");

        NonClosingChangeArrivalDeadlineDate bean =
                new NonClosingChangeArrivalDeadlineDate();
        setFacade(bean, facade);
        bean.setTrackingId("ABC123");

        bean.load();

        assertEquals("ABC123", facade.requestedTrackingId);
        assertSame(facade.cargoToReturn, bean.getCargo());
        assertEquals(new SimpleDateFormat("MM/dd/yyyy").parse("06/15/2014"),
                bean.getArrivalDeadlineDate());
    }

    @Test(expected = RuntimeException.class)
    public void loadSurfacesAMalformedDeadlineDateInsteadOfConvertingItToNull()
            throws Exception {
        RecordingBookingServiceFacade facade = new RecordingBookingServiceFacade();
        facade.cargoToReturn = cargoRouteWithDeadlineDate("not-a-date");

        NonClosingChangeArrivalDeadlineDate bean =
                new NonClosingChangeArrivalDeadlineDate();
        setFacade(bean, facade);
        bean.setTrackingId("ABC123");

        bean.load();
    }

    @Test
    public void changeArrivalDeadlineDelegatesTrackingIdAndSelectedDate()
            throws Exception {
        RecordingBookingServiceFacade facade = new RecordingBookingServiceFacade();

        NonClosingChangeArrivalDeadlineDate bean =
                new NonClosingChangeArrivalDeadlineDate();
        setFacade(bean, facade);
        bean.setTrackingId("ABC123");
        Date selectedDate = new Date(123456789L);
        bean.setArrivalDeadlineDate(selectedDate);

        bean.changeArrivalDeadline();

        assertEquals(1, facade.changeDeadlineCalls);
        assertEquals("ABC123", facade.requestedTrackingId);
        assertSame(selectedDate, facade.requestedDeadline);
        assertEquals(1, bean.closeDialogCalls);
    }

    @Test
    public void changeArrivalDeadlineRejectsANullSelectedDate() throws Exception {
        RecordingBookingServiceFacade facade = new RecordingBookingServiceFacade();

        NonClosingChangeArrivalDeadlineDate bean =
                new NonClosingChangeArrivalDeadlineDate();
        setFacade(bean, facade);
        bean.setTrackingId("ABC123");
        bean.setArrivalDeadlineDate(null);

        bean.changeArrivalDeadline();

        assertEquals(0, facade.changeDeadlineCalls);
        assertEquals(0, bean.closeDialogCalls);
        assertNull(bean.getArrivalDeadlineDate());
    }

    @Test
    public void aFailedFacadeCallDoesNotCloseTheDialog() throws Exception {
        FailingBookingServiceFacade facade = new FailingBookingServiceFacade();

        NonClosingChangeArrivalDeadlineDate bean =
                new NonClosingChangeArrivalDeadlineDate();
        setFacade(bean, facade);
        bean.setTrackingId("ABC123");
        bean.setArrivalDeadlineDate(new Date());

        try {
            bean.changeArrivalDeadline();
            fail("Expected the facade failure to propagate");
        } catch (RuntimeException expected) {
            // expected
        }

        assertEquals("Dialog must not close on a failed submission",
                0, bean.closeDialogCalls);
    }

    private static CargoRoute cargoRouteWithDeadlineDate(final String deadlineDate) {
        return new CargoRoute("ABC123", "USNYC", "SEGOT", new Date(), false,
                false, "USNYC", "IN_PORT") {

            private static final long serialVersionUID = 1L;

            @Override
            public String getArrivalDeadlineDate() {
                return deadlineDate;
            }
        };
    }

    private static void setFacade(ChangeArrivalDeadlineDate bean,
                                   BookingServiceFacade facade) throws Exception {
        Field field = ChangeArrivalDeadlineDate.class
                .getDeclaredField("bookingServiceFacade");
        field.setAccessible(true);
        field.set(bean, facade);
    }

    /**
     * Overrides {@code closeDialog()} so that tests can run without a live
     * {@code FacesContext}/PrimeFaces request, while still recording whether
     * the dialog would have been closed.
     */
    private static final class NonClosingChangeArrivalDeadlineDate
            extends ChangeArrivalDeadlineDate {

        private static final long serialVersionUID = 1L;
        private int closeDialogCalls;

        @Override
        protected void closeDialog() {
            closeDialogCalls++;
        }
    }

    private static final class RecordingBookingServiceFacade
            implements BookingServiceFacade {

        private CargoRoute cargoToReturn;
        private String requestedTrackingId;
        private Date requestedDeadline;
        private int changeDeadlineCalls;

        @Override
        public String bookNewCargo(String origin, String destination,
                                    Date arrivalDeadline) {
            throw new AssertionError("bookNewCargo should not be called");
        }

        @Override
        public CargoRoute loadCargoForRouting(String trackingId) {
            requestedTrackingId = trackingId;
            return cargoToReturn;
        }

        @Override
        public void assignCargoToRoute(String trackingId, RouteCandidate route) {
            throw new AssertionError("assignCargoToRoute should not be called");
        }

        @Override
        public void changeDestination(String trackingId, String destinationUnLocode) {
            throw new AssertionError("changeDestination should not be called");
        }

        @Override
        public void changeDeadline(String trackingId, Date arrivalDeadline) {
            changeDeadlineCalls++;
            requestedTrackingId = trackingId;
            requestedDeadline = arrivalDeadline;
        }

        @Override
        public List<RouteCandidate> requestPossibleRoutesForCargo(String trackingId) {
            throw new AssertionError(
                    "requestPossibleRoutesForCargo should not be called");
        }

        @Override
        public List<Location> listShippingLocations() {
            throw new AssertionError("listShippingLocations should not be called");
        }

        @Override
        public List<CargoRoute> listAllCargos() {
            throw new AssertionError("listAllCargos should not be called");
        }
    }

    private static final class FailingBookingServiceFacade
            implements BookingServiceFacade {

        @Override
        public String bookNewCargo(String origin, String destination,
                                    Date arrivalDeadline) {
            throw new AssertionError("bookNewCargo should not be called");
        }

        @Override
        public CargoRoute loadCargoForRouting(String trackingId) {
            throw new AssertionError("loadCargoForRouting should not be called");
        }

        @Override
        public void assignCargoToRoute(String trackingId, RouteCandidate route) {
            throw new AssertionError("assignCargoToRoute should not be called");
        }

        @Override
        public void changeDestination(String trackingId, String destinationUnLocode) {
            throw new AssertionError("changeDestination should not be called");
        }

        @Override
        public void changeDeadline(String trackingId, Date arrivalDeadline) {
            throw new RuntimeException("Simulated facade failure");
        }

        @Override
        public List<RouteCandidate> requestPossibleRoutesForCargo(String trackingId) {
            throw new AssertionError(
                    "requestPossibleRoutesForCargo should not be called");
        }

        @Override
        public List<Location> listShippingLocations() {
            throw new AssertionError("listShippingLocations should not be called");
        }

        @Override
        public List<CargoRoute> listAllCargos() {
            throw new AssertionError("listAllCargos should not be called");
        }
    }
}
