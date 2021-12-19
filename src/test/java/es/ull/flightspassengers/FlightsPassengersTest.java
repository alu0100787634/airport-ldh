package es.ull.flightspassengers;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Checking both classes")
@Nested
public class FlightsPassengersTest {
    private Flight flight;
    private Passenger jordan;
    private Passenger jackson;

    @BeforeEach
    void setUp() {
        flight = new Flight("ZZ023", 100);
        jordan = new Passenger("23","Jordan","MX");
        jackson = new Passenger("08","Jackson","US");
    }

    @Nested
    @DisplayName("Flights")
    class FlightMethods {

        @Test
        @DisplayName("Cheking assign")
        public void testFlightAddPassenger() {
            assertAll("is assigment ok",
                    () -> assertEquals(0, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.addPassenger(jackson)),
                    () -> assertEquals(1, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.addPassenger(jordan)),
                    () -> assertEquals(2, flight.getNumberOfPassengers())
            );
        }

        @DisplayName("Cheking something strange")
        @RepeatedTest(5)
        public void testFlightAddPassenger5(RepetitionInfo repetitionInfo) {
            for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                flight.addPassenger(jackson);
            }
            assertAll("is this passenger God",
                    () -> assertEquals(1, flight.getNumberOfPassengers())
            );
        }

        @Test
        @DisplayName("Deleting passenger")
        public void testFlightRemovePassenger() {
            assertAll("can be eliminated",
                    () -> assertEquals(0, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.addPassenger(jackson)),
                    () -> assertEquals(1, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.addPassenger(jordan)),
                    () -> assertEquals(2, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.removePassenger(jackson)),
                    () -> assertEquals(1, flight.getNumberOfPassengers())
            );
        }
    }

    @Nested
    @DisplayName("Passengers")
    class PassengerMethods {

        @Test
        @DisplayName("Cheking passenger assignments")
        public void testPassengerFlight() {
            assertAll("Cheking flight data",
                    () -> assertTrue(flight.addPassenger(jackson)),
                    () -> assertEquals(flight, jackson.getFlight())
            );
        }

        @Test
        @DisplayName("Forcing manual")
        public void testPassengerChangeFlight() {
            Flight newFlight = new Flight("ZZ023", 150);
            assertAll("Manual cheking",
                    () -> assertNull(jackson.getFlight()),
                    () -> assertEquals(0, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.addPassenger(jackson)),
                    () -> assertEquals(1 ,flight.getNumberOfPassengers()),
                    () -> assertEquals(flight, jordan.getFlight())
            );
            jordan.joinFlight(newFlight);
            assertEquals(newFlight, jordan.getFlight());
        }
    }

}