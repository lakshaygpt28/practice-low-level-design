package Questions.ElevatorSystem.model;

import Questions.Amazon.util.IdGenerator;
import Questions.ElevatorSystem.model.button.Button;
import Questions.ElevatorSystem.model.button.InternalButton;

public class ElevatorCar {
    private int id;
    private Button button;
    private Door door;
    private Direction direction;
    private int currentFloor;

    public ElevatorCar(int id) {
        this.id = id;
        this.button = new InternalButton();
        this.door = new Door();
        this.direction = Direction.IDLE;
        this.currentFloor = 1;
    }

    public void pressButton(int floor) {
        direction = Direction.IDLE;
        if (currentFloor > floor) {
            direction = Direction.UP;
        } else if (currentFloor < floor) {
            direction = Direction.DOWN;
        }
        button.pressButton(floor, direction, id);
    }
}
