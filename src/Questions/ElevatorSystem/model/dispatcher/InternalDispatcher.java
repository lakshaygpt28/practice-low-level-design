package Questions.ElevatorSystem.model.dispatcher;

import Questions.ElevatorSystem.ElevatorController;
import Questions.ElevatorSystem.ElevatorSystem;
import Questions.ElevatorSystem.model.Direction;

public class InternalDispatcher {
    private ElevatorSystem elevatorSystem;

    public InternalDispatcher() {
        elevatorSystem = ElevatorSystem.getInstance();
    }

    public void submitRequest(int floor, Direction direction, int elevatorId) {
        ElevatorController elevatorController = elevatorSystem.getElevatorControllers().get(elevatorId);

        elevatorController.acceptRequest(floor, direction);
    }
}
