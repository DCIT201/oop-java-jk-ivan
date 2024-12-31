public abstract class Vehicle implements Rentable {
    // Encapsulated private fields
    private final String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private int mileage;
    private VehicleCondition condition;

    // Enum for vehicle condition
    public enum VehicleCondition {
        EXCELLENT, GOOD, FAIR, POOR
    }

    // Protected constructor for initialization
    protected Vehicle(String vehicleId, String model, double baseRentalRate) {
        this.vehicleId = validateVehicleId(vehicleId);
        setModel(model);
        setBaseRentalRate(baseRentalRate);
        this.isAvailable = true;
        this.mileage = 0;
        this.condition = VehicleCondition.EXCELLENT;
    }

    // Validation methods
    private String validateVehicleId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty");
        }
        return id;
    }

    // Getters with controlled access
    public final String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        this.model = model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double rate) {
        if (rate <= 0) {
            throw new IllegalArgumentException("Rental rate must be positive");
        }
        this.baseRentalRate = rate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getMileage() {
        return mileage;
    }

    public void updateMileage(int additionalMileage) {
        if (additionalMileage < 0) {
            throw new IllegalArgumentException("Mileage cannot be negative");
        }
        this.mileage += additionalMileage;
    }

    public VehicleCondition getCondition() {
        return condition;
    }

    public void updateCondition(VehicleCondition newCondition) {
        this.condition = newCondition;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calculateSpecialRentalRate(int rentalDays);

    @Override
    public double calculateTotalRentalCost() {
        return calculateSpecialRentalRate(7); // Default implementation
    }

    // Default implementation with option to override

    public boolean rent(Customer customer, int rentalDays) throws RentalException {
        if (!isAvailable) {
            throw new RentalException("Vehicle is not available for rental");
        }

        if (customer.canRent()) {
            setAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnVehicle() {
        setAvailable(true);
        return true;
    }

    // Override Object methods
    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", rate=" + baseRentalRate +
                ", available=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleId.equals(vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return vehicleId.hashCode();
    }
}
