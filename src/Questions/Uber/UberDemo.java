package Questions.Uber;

import Questions.Uber.model.Customer;
import Questions.Uber.model.Driver;
import Questions.Uber.model.Location;
import Questions.Uber.model.Ride;
import Questions.Uber.service.RideService;

public class UberDemo {
    public static void main(String[] args) {
        RideService rideService = new RideService();

        Customer customer1 = new Customer("Alice", new Location(123.0, -123.0));
        Customer customer2 = new Customer("Bob", new Location(31.0, -64.34));

        Driver driver1 = new Driver("Driver 1", "Swift", new Location(55, 55));
        Driver driver2 = new Driver("Driver 2", "Alto", new Location(24, 42));

        rideService.registerDriver(driver1);
        rideService.registerDriver(driver2);

        // Passenger 1 requests a ride
        rideService.requestRide(customer1, customer1.getLocation(), new Location(37.7887, -122.4098));

        // Driver 1 accepts the ride
        Ride ride = rideService.getRequestedRides().poll();
        rideService.acceptRide(driver1, ride);

        // Start the ride
        rideService.startRide(ride, "6969");

        // Complete the ride
        rideService.completeRide(ride);

        // Passenger 2 requests a ride
        rideService.requestRide(customer2, customer2.getLocation(), new Location(37.7749, -122.4194));

        // Driver 2 accepts the ride
        Ride ride2 = rideService.getRequestedRides().poll();
        rideService.acceptRide(driver2, ride2);

        // Passenger 2 cancels the ride
        rideService.cancelRide(ride2);

    }
}
