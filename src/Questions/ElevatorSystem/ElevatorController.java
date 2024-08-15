package Questions.ElevatorSystem;

import Questions.Amazon.util.IdGenerator;
import Questions.ElevatorSystem.model.Direction;
import Questions.ElevatorSystem.model.ElevatorCar;
import Questions.ElevatorSystem.model.Request;
import lombok.Getter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Getter
public class ElevatorController {
    private final int id;
    private ElevatorCar elevatorCar;
    private Queue<Request> pendingRequests;
    private ElevatorSystem elevatorSystem;

    ElevatorController() {
        this.id = IdGenerator.getNextId(ElevatorController.class);
        this.elevatorCar = new ElevatorCar(this.id);
        this.pendingRequests = new ConcurrentLinkedQueue<>();
        this.elevatorSystem = ElevatorSystem.getInstance();
    }

    public void acceptRequest(int floor, Direction direction) {
        Request request = new Request(floor, direction);
        pendingRequests.offer(request);
        controlCar();
    }

    private void controlCar() {
        System.out.println("Elevator: " + id + " is moving....");
        elevatorSystem.getElevatorControlStrategy().moveElevator(this);

    }
}
