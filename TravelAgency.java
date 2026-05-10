import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class TravelAgency {
    private ArrayList<Trip> trips;
    private ArrayList<Customer> customers;
    private ArrayList<Booking> bookings;

    public TravelAgency() {
        trips = new ArrayList<>();
        customers = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public Booking bookTrip(Customer customer, Trip trip, LocalDate departureDate, int duration) throws IllegalArgumentException {
        if (trip.isLongDistance() && customer.getAgeAt(departureDate) < 18) {
            throw new IllegalArgumentException("Customer must be 18 or older for long-distance trips.");
        }
        Booking booking = new Booking(customer, trip, departureDate, duration);
        customer.addBooking(booking);
        bookings.add(booking);
        return booking;
    }

    public void showPopularDestinations() {
        Map<String, Long> counts = bookings.stream()
                .filter(b -> !b.isCanceled())
                .collect(Collectors.groupingBy(b -> b.getTrip().getDestination(), Collectors.counting()));
        System.out.println("Popular destinations:");
        counts.forEach((dest, count) -> System.out.println(dest + ": " + count + " bookings"));
    }

    public void cancelBooking(Booking booking) {
        booking.cancelBooking();
    }
}