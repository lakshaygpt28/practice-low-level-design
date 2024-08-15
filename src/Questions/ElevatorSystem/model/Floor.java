package Questions.ElevatorSystem.model;

import Questions.ElevatorSystem.model.button.Button;
import Questions.ElevatorSystem.model.button.ExternalButton;
import lombok.Getter;

@Getter
public class Floor {
    private int id;
    private Button button;

    public Floor(int id) {
        this.id = id;
        this.button = new ExternalButton();
    }

    public void pressButton(Direction direction) {
        button.pressButton(id, direction);
    }
}
