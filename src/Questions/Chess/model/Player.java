package Questions.Chess.model;

import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private final Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}
