package es.ull.passengers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Passengers Testing")
@Nested
public class PassengersTest {
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        passenger = new Passenger("23","Jordan","MX");
    }

    @Nested
    @DisplayName("Match!")
    class NormalPassanger {

        @Test
        @DisplayName("Cheking passenger data")
        public void testAtributosPassenger() {
            assertAll("Formating data",
                    () -> assertEquals("23", passenger.getIdentifier()),
                    () -> assertEquals("Jordan", passenger.getName()),
                    () -> assertEquals("MX", passenger.getCountryCode())
            );
        }
    }
}