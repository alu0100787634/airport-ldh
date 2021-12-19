package es.ull.flights;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Flight Testing")
@Nested
public class FlightTest {
    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight("ZZ023", 100);
    }

    @Nested
    @DisplayName("Standard class")
    class NormalFlight {

        @Test
        @DisplayName("Cheking flight data")
        public void testAtributosFlight() {
            assertAll("Cheking flight data",
                    () -> assertEquals("ZZ023", flight.getFlightNumber()),
                    () -> assertEquals(0, flight.getNumberOfPassengers())
            );
        }
    }

}
