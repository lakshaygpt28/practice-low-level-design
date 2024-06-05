package Questions.ParkingLot;

public class Ticket {
    String ticketId;
    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        ticketId = String.valueOf(parkingSpot.parkingLotId) + '_' +
                parkingSpot.floorNo + '_' +
                parkingSpot.spotNo;
    }
}
