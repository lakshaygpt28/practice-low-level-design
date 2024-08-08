package Questions.Uber.dao;

import Questions.Uber.model.Driver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverDao {
    Map<Integer, Driver> drivers;

    public DriverDao() {
        drivers = new ConcurrentHashMap<>();
    }

    public Map<Integer, Driver> getDrivers() {
        return drivers;
    }

    public Driver getDriver(int driverId) {
        return drivers.get(driverId);
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }
}
