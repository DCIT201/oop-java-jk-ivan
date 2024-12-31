public interface Rentable {
    boolean rent(Rentable customer, int rentalDays);
    boolean returnVehicle();
    double calculateTotalRentalCost();
}

