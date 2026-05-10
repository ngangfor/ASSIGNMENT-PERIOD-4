import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Customer {
    private String name;
    private LocalDate birthDate;
    private ArrayList<Booking> bookings;

    public Customer(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void viewBookings() {
        System.out.println("Bookings for " + name + ":");
        for (Booking b : bookings) {
            System.out.println(" - " + b.getTrip().getDestination() + " on " + b.getDepartureDate());
        }
    }

    public int getAgeAt(LocalDate date) {
        return Period.between(birthDate, date).getYears();
    }

    public String getName() { return name; }
    // other getters if needed
}