package Questions.Uber.service;

import Questions.Uber.dao.DriverDao;
import Questions.Uber.model.Driver;

import java.util.List;
import java.util.Map;

public class DriverService {
    DriverDao driverDao;
    private static DriverService instance;

    DriverService() {
        driverDao = new DriverDao();
    }

    public static synchronized DriverService getInstance() {
        if (instance == null) {
            instance = new DriverService();
        }
        return instance;
    }

    public Map<Integer, Driver> getDrivers() {
        return driverDao.getDrivers();
    }

    public Driver getDriver(int driverId) {
        return driverDao.getDriver(driverId);
    }

    public void addDriver(Driver driver) {
        driverDao.addDriver(driver);
    }
}
