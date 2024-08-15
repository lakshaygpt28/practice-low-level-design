package Questions.ElevatorSystem.model;

public class Door {
    public void open(int elevatorId) {
        System.out.println("Opened the Door for elevator: " + elevatorId);
    }

    public void close(int elevatorId) {
        System.out.println("Closed the Door for elevator: " + elevatorId);
    }
}
