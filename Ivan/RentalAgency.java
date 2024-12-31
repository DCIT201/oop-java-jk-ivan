import java.util.stream.Collectors;

public class RentalAgency {
    private String name;
    private String vehicles;
    private String customers;
    private String rentalTranscations;

    public RentalAgency(String name) {
        this.name = name;
        this.vehicles = vehicles;
        this.customers = customers;
        this.rentalTranscations = rentalTranscations;
    }

    public RentalTransaction rentVehicle(Customer customer, Vehicle vehicle, int rentalDays) throws RentalException {
        if (!vehicle.isAvailable()) {
            throw new VehicleUnavailableException("Vehicle is not available");
        }

        if (vehicle.rent(customer, rentalDays)) {
            RentalTransaction transaction = new RentalTransaction(customer, vehicle, rentalDays);
            transactions.add(transaction);
            customer.addRentalTransaction(transaction);
            return transaction;
        }

        throw new RentalException("Rental could not be processed");
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Generate reports and perform other agency-level operations
    public String Vehicle (){
        return vehicles.stream()
                .filter(Vehicle::isAvailable)
                .collect(Collectors.toList());
    }
}

