package Questions.Chess.model.piece;

import Questions.Chess.model.Board;
import Questions.Chess.model.Color;
import Questions.Chess.model.Position;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        return false;
    }
}