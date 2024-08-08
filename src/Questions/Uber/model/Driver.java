package Questions.Uber.model;

import Questions.Uber.util.IdGenerator;

public class Driver {
    int id;
    String name;
    String vehicle;
    Location location;
    DriverStatus status;

    public Driver(String name, String vehicle, Location location) {
        this.id = IdGenerator.getNextId(Driver.class);
        this.name = name;
        this.vehicle = vehicle;
        this.location = location;
        this.status = DriverStatus.AVAILABLE;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }
}
