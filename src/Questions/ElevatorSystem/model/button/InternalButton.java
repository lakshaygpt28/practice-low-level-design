package Questions.ElevatorSystem.model.button;

import Questions.ElevatorSystem.model.Direction;
import Questions.ElevatorSystem.model.dispatcher.InternalDispatcher;

public class InternalButton extends Button {
    InternalDispatcher iDispatcher;

    public InternalButton() {
        iDispatcher = new InternalDispatcher();
    }

    @Override
    public void pressButton(int floor, Direction dir, int elevatorId) {
        System.out.println("Pressed floor "+ floor + " from elevator "+ elevatorId);
        iDispatcher.submitRequest(floor, dir, elevatorId);
    }
}
