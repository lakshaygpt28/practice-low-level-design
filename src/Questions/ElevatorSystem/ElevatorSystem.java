package Questions.ElevatorSystem;

import Questions.ElevatorSystem.elevatorControlStrategy.ElevatorControlStrategy;
import Questions.ElevatorSystem.elevatorSelectionStrategy.ElevatorSelectionStrategy;
import Questions.ElevatorSystem.model.Floor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ElevatorSystem {
    private static ElevatorSystem instance;
    private final Map<Integer, ElevatorController> elevatorControllers;
    private final Map<Integer, Floor> floors;
    @Setter
    private ElevatorControlStrategy elevatorControlStrategy;
    @Setter
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    ElevatorSystem() {
        this.elevatorControllers = new ConcurrentHashMap<>();
        this.floors = new ConcurrentHashMap<>();
        this.elevatorControlStrategy = new ElevatorControlStrategy();
        this.elevatorSelectionStrategy = new ElevatorSelectionStrategy();
    }

    public static synchronized ElevatorSystem getInstance() {
        if (instance == null) {
            instance = new ElevatorSystem();
        }
        return instance;
    }

    public void addFloor(Floor floor) {
        floors.put(floor.getId(), floor);
    }

    public void addElevator(ElevatorController elevatorController) {

        elevatorControllers.put(elevatorController.getId(), elevatorController);
    }

}
