package Questions.SnakeAndLadderGame.model;

import lombok.Getter;

@Getter
public class Ladder {
    int startPosition;
    int endPosition;

    public Ladder(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}
