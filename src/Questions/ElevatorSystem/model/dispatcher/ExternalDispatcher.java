package Questions.ElevatorSystem.model.dispatcher;

import Questions.ElevatorSystem.ElevatorController;
import Questions.ElevatorSystem.ElevatorSystem;
import Questions.ElevatorSystem.model.Direction;
import Questions.ElevatorSystem.model.ElevatorCar;

public class ExternalDispatcher {
    private static ExternalDispatcher instance;
    private ElevatorSystem elevatorSystem;

    ExternalDispatcher() {
        elevatorSystem = ElevatorSystem.getInstance();
    }

    public static synchronized ExternalDispatcher getInstance() {
        if (instance == null) {
            instance = new ExternalDispatcher();
        }
        return instance;
    }

    public void submitRequest(int floor, Direction direction) {
        int elevatorControllerId = elevatorSystem.getElevatorSelectionStrategy().selectElevator(floor, direction);

        ElevatorController elevatorController = elevatorSystem.getElevatorControllers().get(elevatorControllerId);

        elevatorController.acceptRequest(floor, direction);
    }
}
