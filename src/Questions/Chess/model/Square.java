package Questions.Chess.model;

import Questions.Chess.model.piece.Piece;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Square {
    private final Position position;
    @Setter
    private Piece piece;

    public Square(Position position, Piece piece) {
        this.position = position;
        this.piece = piece;
    }
}
