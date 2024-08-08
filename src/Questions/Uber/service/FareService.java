package Questions.Uber.service;

import Questions.Uber.model.Location;

public class FareService {
    private final DistanceService distanceService;

    public FareService() {
        distanceService = new DistanceService();
    }

    public double calculateFare(Location source, Location destination) {
        double baseFare = 20.0;
        double perKmFare = 5.0;
        double distance = distanceService.calculateDistance(source, destination);
        return baseFare + perKmFare * distance;
    }
}
