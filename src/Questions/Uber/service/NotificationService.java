package Questions.Uber.service;

import Questions.Uber.model.Customer;
import Questions.Uber.model.Driver;
import Questions.Uber.model.DriverStatus;
import Questions.Uber.model.Ride;

public class NotificationService {
    private final DriverService driverService;
    private final DistanceService distanceService;

    public NotificationService() {
        driverService = DriverService.getInstance();
        distanceService = new DistanceService();
    }


    public void notifyDrivers(Ride ride) {
        for (Driver driver : driverService.getDrivers().values()) {
            if (driver.getStatus() == DriverStatus.AVAILABLE) {
                if (distanceService.calculateDistance(driver.getLocation(), ride.getSource()) <= 5.0) {
                    System.out.println("Notifying Driver: " + driver.getName() + ", New Ride: " + ride.getId() + " is available");
                }
            }
        }
    }

    public void notifyDriver(Ride ride) {
        Driver driver = ride.getDriver();
        if (driver != null) {
            String message = switch (ride.getStatus()) {
                case COMPLETED -> "Ride completed. Fare: $" + ride.getFare();
                case CANCELLED -> "Ride cancelled by passenger";
                default -> "";
            };
            // Send notification to the driver
            System.out.println("Notifying driver: " + driver.getName() + " - " + message);
        }
    }

    public void notifyCustomer(Ride ride) {
        Customer customer = ride.getCustomer();
        String message = switch (ride.getStatus()) {
            case ACCEPTED -> "Your ride is accepted by driver: " + ride.getDriver().getName();
            case STARTED -> "Your ride has started.";
            case CANCELLED -> "Your ride has been cancelled.";
            case COMPLETED -> "Your ride has been completed. Fare $: " + ride.getFare();
            case REQUESTED -> "Your ride has been offered to near by drivers.";
        };
        // Sending Notification
        System.out.println("Notifying customer: " + customer.getName() + " - " + message);
    }
}
