public class Trip {
    private String tripCode;
    private String destination;
    private double price;
    private boolean longDistance;

    public Trip(String tripCode, String destination, double price, boolean longDistance) {
        this.tripCode = tripCode;
        this.destination = destination;
        this.price = price;
        this.longDistance = longDistance;
    }

    public void displayTrip() {
        System.out.printf("%s - %s ($%.2f) %s%n",
                tripCode, destination, price,
                longDistance ? "(Long Distance)" : "(Short Distance)");
    }

    // Getters
    public String getDestination() { return destination; }
    public double getPrice() { return price; }
    public boolean isLongDistance() { return longDistance; }
}