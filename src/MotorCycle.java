abstract class Motorcycle extends Vehicle {
    private final boolean hasSideCar;
    private int engineCapacity;

    public Motorcycle(String vehicleId, String model, double baseRate,
                      int engineCapacity, boolean hasSideCar) {
        super(vehicleId, model, baseRate);
        setEngineCapacity(engineCapacity);
        this.hasSideCar = hasSideCar;
    }

    public void setEngineCapacity(int capacity) {
        if (capacity < 50 || capacity > 1500) {
            throw new IllegalArgumentException("Invalid engine capacity");
        }
        this.engineCapacity = capacity;
    }

    @Override
    public double calculateSpecialRentalRate(int rentalDays) {
        double baseRate = getBaseRentalRate();
        // Add premium for sidecar
        return hasSideCar ? baseRate * rentalDays * 1.2 : baseRate * rentalDays;
    }
}