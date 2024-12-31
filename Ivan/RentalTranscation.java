public class RentalTransaction {
    private final String transactionId;
    private final Customer customer;
    private final Vehicle vehicle;
    private final int rentalDays;
    private final double totalCost;
    private int returnDate;

    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
        this.transactionId = generateTransactionId();
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.totalCost = vehicle.calculateTotalRentalCost();
    }

    private String generateTransactionId() {
        return "RENT-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
