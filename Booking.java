import java.time.LocalDate;

public class Booking {
    private Customer customer;
    private Trip trip;
    private LocalDate departureDate;
    private int duration; // in days
    private boolean canceled;

    public Booking(Customer customer, Trip trip, LocalDate departureDate, int duration) {
        this.customer = customer;
        this.trip = trip;
        this.departureDate = departureDate;
        this.duration = duration;
        this.canceled = false;
    }

    public void cancelBooking() {
        this.canceled = true;
    }

    public double calculateCancellationFee() {
        if (canceled) {
            // 10% of trip price
            return trip.getPrice() * 0.10;
        }
        return 0.0;
    }

    public Trip getTrip() { return trip; }
    public LocalDate getDepartureDate() { return departureDate; }
    public boolean isCanceled() { return canceled; }
    public Customer getCustomer() { return customer; }
}