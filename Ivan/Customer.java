public class Customer {
    private final String customerId;
    private String name;
    private String contactNumber;
    private String rentalHistory;
    private int totalRentals;
    private boolean isEligibleForRental;

    public Customer(String customerId, String name, String contactNumber) {
        this.customerId = customerId;
        setName(name);
        setContactNumber(contactNumber);
        this.rentalHistory = rentalHistory;
        this.totalRentals = 0;
        this.isEligibleForRental = true;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        if (!contactNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid contact number");
        }
        this.contactNumber = contactNumber;
    }

    public boolean canRent() {
        return isEligibleForRental && totalRentals < 5;
    }

    public void addRentalTransaction(RentalTransaction transaction) {
        rentalHistory.add(transaction);
        totalRentals++;
    }
}
