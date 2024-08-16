package Questions.SnakeAndLadderGame.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String name;
    @Setter
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }
}
