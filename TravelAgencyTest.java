import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.time.LocalDate;

public class TravelAgencyTest {
    private TravelAgency agency;
    private Trip shortTrip;
    private Trip longTrip;
    private Customer adult;
    private Customer minor;

    @BeforeEach
    void setUp() {
        agency = new TravelAgency();
        shortTrip = new Trip("T01", "Paris", 700, false);
        longTrip = new Trip("T02", "NYC", 1200, true);
        adult = new Customer("Adult", LocalDate.of(2000, 1, 1));
        minor = new Customer("Minor", LocalDate.of(2015, 1, 1));
        agency.addTrip(shortTrip);
        agency.addTrip(longTrip);
    }

    @Test
    void testBookShortTrip() {
        assertDoesNotThrow(() -> agency.bookTrip(adult, shortTrip, LocalDate.of(2026, 6, 1), 5));
    }

    @Test
    void testUnderageBlockedForLongDistance() {
        assertThrows(IllegalArgumentException.class,
                () -> agency.bookTrip(minor, longTrip, LocalDate.of(2026, 6, 1), 5));
    }

    @Test
    void testCancellationFee() {
        Booking booking = new Booking(adult, shortTrip, LocalDate.of(2026, 6, 1), 5);
        booking.cancelBooking();
        assertEquals(70.0, booking.calculateCancellationFee(), 0.01); // 10% of 700
    }
}