package Questions.Uber.service;

import Questions.Uber.model.*;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RideService {
    private final Queue<Ride> requestedRides;
    DriverService driverService;
    NotificationService notificationService;
    FareService fareService;

    public RideService() {
        requestedRides = new ConcurrentLinkedQueue<>();
        driverService = DriverService.getInstance();
        notificationService = new NotificationService();
        fareService = new FareService();
    }

    public Queue<Ride> getRequestedRides() {
        return requestedRides;
    }

    public void registerCustomer(Customer customer) {

    }

    public void registerDriver(Driver driver) {
        driverService.addDriver(driver);
    }

    // find ride
    public void requestRide(Customer customer, Location source, Location destination) {
        Double fare = fareService.calculateFare(source, destination);
        Ride ride = new Ride(customer, null, source, destination, fare);
        requestedRides.offer(ride);
        notificationService.notifyDrivers(ride);
        notificationService.notifyCustomer(ride);
    }

    public void acceptRide(Driver driver, Ride ride) {
        if (driver.getStatus() == DriverStatus.BUSY) {
            System.out.println("Driver cannot accept the ride as driver is busy.");
            return;
        }
        if (ride.getStatus() != RideStatus.REQUESTED) {
            System.out.println("Ride is already accepted or completed or cancelled");
            return;
        }
        driver.setStatus(DriverStatus.BUSY);
        ride.setDriver(driver);
        ride.setStatus(RideStatus.ACCEPTED);
        ride.setOTP("6969");
        notificationService.notifyCustomer(ride);
    }

    public void startRide(Ride ride, String OTP) {
        if (OTP.equals(ride.getOTP())) {
            ride.setStatus(RideStatus.STARTED);
            notificationService.notifyCustomer(ride);
        } else {
            System.out.println("OTP is not correct. Try Again!!!");
        }
    }

    public void completeRide(Ride ride) {
        if (ride.getStatus() == RideStatus.STARTED) {
            ride.setStatus(RideStatus.COMPLETED);
            ride.getDriver().setStatus(DriverStatus.AVAILABLE);
            notificationService.notifyCustomer(ride);
        }
    }

    public void cancelRide(Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED || ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setStatus(RideStatus.CANCELLED);
            if (ride.getDriver() != null) {
                ride.getDriver().setStatus(DriverStatus.AVAILABLE);
            }
            notificationService.notifyCustomer(ride);
            notificationService.notifyDriver(ride);
        }
    }

    public void processPayment(double requiredAmount, double transferredAmount) {
        // process payment
        if (transferredAmount >= requiredAmount) {
            System.out.println("Payment processed successfully");
        }
    }
}
