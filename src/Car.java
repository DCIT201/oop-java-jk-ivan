public abstract class Car extends Vehicle implements Loyaltable {
    private int passengerCapacity;
    private boolean hasAirConditioning;
    private int loyaltyPoints;

    // Static factory method
    public static Car createEconomyCar(String id, String model) {
        return new Car(id, model, 50.0, 4, false) {
            @Override
            public boolean rent(Rentable customer, int rentalDays) {
                return false;
            }
        };
    }

    public static Car createLuxuryCar(String id, String model) {
        return new Car(id, model, 150.0, 4, true) {
            @Override
            public boolean rent(Rentable customer, int rentalDays) {
                return false;
            }
        };
    }

    public Car(String vehicleId, String model, double baseRate,
               int passengerCapacity, boolean hasAirConditioning) {
        super(vehicleId, model, baseRate);
        setPassengerCapacity(passengerCapacity);
        this.hasAirConditioning = hasAirConditioning;
        this.loyaltyPoints = 0;
    }

    public void setPassengerCapacity(int capacity) {
        if (capacity <= 0 || capacity > 8) {
            throw new IllegalArgumentException("Invalid passenger capacity");
        }
        this.passengerCapacity = capacity;
    }

    @Override
    public double calculateSpecialRentalRate(int rentalDays) {
        double baseRate = getBaseRentalRate();
        // Apply discounts for longer rentals
        if (rentalDays > 7) {
            return baseRate * rentalDays * 0.9; // 10% discount for week-long rentals
        }
        return baseRate * rentalDays;
    }

    @Override
    public void updateLoyaltyPoints(int rentalDays) {
        loyaltyPoints += rentalDays * 2;
    }

    @Override
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}



