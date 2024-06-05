package Questions.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    int parkingLotId;
    Map<String, ParkingSpot> mp;
    ParkingLot(int parkingLotId, int noOfFloors, int noOfSpotsPerFloor) {
        mp = new HashMap<>();
        for (int floorNo = 1; floorNo <= noOfFloors; floorNo++) {
            for (int spotNo = 1; spotNo <= noOfSpotsPerFloor; spotNo++) {
                String key = String.valueOf(parkingLotId) + '_' +
                        floorNo + '_' +
                        spotNo;
                if (spotNo == 1) {
                    mp.put(key, new ParkingSpot(VehicleType.Truck, floorNo, spotNo));
                } else if (spotNo < 4) {
                    mp.put(key, new ParkingSpot(VehicleType.Bike, floorNo, spotNo));
                } else {
                    mp.put(key, new ParkingSpot(VehicleType.Car, floorNo, spotNo));
                }
            }
        }
    }

}

