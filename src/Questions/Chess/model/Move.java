package Questions.Chess.model;

import Questions.Chess.model.piece.Piece;
import lombok.Getter;

@Getter
public class Move {
    private Player player;
    private Square start;
    private Square end;

    public Move(Player player, Square start, Square end) {
        this.player = player;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        Piece piece = end.getPiece();
        String pieceDescription = "";
        if (piece != null) {
            pieceDescription = piece.getColor() + " " + piece.getClass().getSimpleName();
        }
        return String.format("%s from %s to %s",
                pieceDescription,
                start.getPosition(),
                end.getPosition());
    }
}
