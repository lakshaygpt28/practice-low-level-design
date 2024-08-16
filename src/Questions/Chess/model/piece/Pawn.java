package Questions.Chess.model.piece;

import Questions.Chess.model.Board;
import Questions.Chess.model.Color;
import Questions.Chess.model.Position;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        if (getColor() == Color.WHITE) {
            return true;
        } else {

        }
        return true;
    }
}
