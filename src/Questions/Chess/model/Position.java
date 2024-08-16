package Questions.Chess.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        char file = (char)(col + 'A');
        int rank = row + 1;
        return String.format("%c%d", file, rank);
    }
}
