package Questions.Chess.model.piece;


import Questions.Chess.model.Board;
import Questions.Chess.model.Color;
import Questions.Chess.model.Position;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Piece {
    @Setter
    private Boolean isCaptured;
    private final Color color;

    public Piece(Color color) {
        this.color = color;
        this.isCaptured = false;
    }

    public abstract boolean canMove(Board board, Position from, Position to);
}
