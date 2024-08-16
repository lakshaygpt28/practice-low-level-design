package Questions.SnakeAndLadderGame.model;

import lombok.Getter;

@Getter
public class Snake {
    int startPosition;
    int endPosition;

    public Snake(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}
