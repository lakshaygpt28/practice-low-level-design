package Questions.ElevatorSystem.model.button;

import Questions.ElevatorSystem.model.Direction;
import Questions.ElevatorSystem.model.dispatcher.ExternalDispatcher;

public class ExternalButton extends Button {
    ExternalDispatcher eDispatcher = ExternalDispatcher.getInstance();
    @Override
    public void pressButton(int floor, Direction direction) {
        System.out.println("Pressed " + direction + " from floor " + floor);
        eDispatcher.submitRequest(floor, direction);
    }
}
