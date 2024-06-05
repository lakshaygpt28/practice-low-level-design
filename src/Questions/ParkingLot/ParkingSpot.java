package Questions.ParkingLot;

public class ParkingSpot {
    VehicleType spotType;
    boolean isAvailable;
    int floorNo;
    int spotNo;

    Vehicle vehicle;

    int parkingLotId;

    ParkingSpot(VehicleType spotType, int floorNo, int spotNo) {
        this.spotType = spotType;
        this.floorNo = floorNo;
        this.spotNo = spotNo;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.isAvailable = false;
        this.vehicle = vehicle;
    }

    public Vehicle unParkVehicle() {
        Vehicle v = this.vehicle;
        this.isAvailable = true;
        this.vehicle = null;
        return v;
    }
}
