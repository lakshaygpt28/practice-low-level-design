package Questions.ElevatorSystem.elevatorSelectionStrategy;

import Questions.ElevatorSystem.ElevatorSystem;
import Questions.ElevatorSystem.model.Direction;

import java.util.concurrent.ThreadLocalRandom;

public class OddEvenStrategy extends ElevatorSelectionStrategy {
    @Override
    public int selectElevator(int floor, Direction direction) {
        return ThreadLocalRandom.current().nextInt(1, ElevatorSystem.getInstance().getElevatorControllers().size());
    }
}
