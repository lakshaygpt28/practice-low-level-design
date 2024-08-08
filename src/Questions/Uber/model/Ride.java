package Questions.Uber.model;

import Questions.Uber.util.IdGenerator;

public class Ride {
    int id;
    Customer customer;
    Driver driver;
    Location source;
    Location destination;
    Double fare;
    RideStatus status;
    String OTP;

    public Ride(Customer customer, Driver driver, Location source, Location destination, Double fare) {
        this.id = IdGenerator.getNextId(Ride.class);
        this.customer = customer;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.status = RideStatus.REQUESTED;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public int getId() {
        return id;
    }
}
