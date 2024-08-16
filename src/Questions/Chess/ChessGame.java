package Questions.Chess;

import Questions.Chess.model.*;
import Questions.Chess.model.piece.Piece;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ChessGame {
    private final Board board;
    private final Map<Color, Player> players;
    private Color currentPlayerColor;

    public ChessGame(Player whitePlayer, Player blackPlayer) {
        board = new Board();
        players = new HashMap<>();
        players.put(Color.WHITE, whitePlayer);
        players.put(Color.BLACK, blackPlayer);
        currentPlayerColor = Color.WHITE;
    }

    public void makeMove(Player player, Position from, Position to) {
        Square start = board.getBlock(from);
        Square end = board.getBlock(to);
        Move move = new Move(player, start, end);
        if (isValidMove(move)) {
            board.executeMove(move);
            System.out.println(player.getName() + " moved " + move);
            switchPlayer();
        } else {
            System.out.println("Invalid Move !!!");
        }
    }

    private boolean isValidMove(Move move) {
        if (move.getPlayer() != players.get(currentPlayerColor)) {
            System.out.println("Not your turn !!!");
            return false;
        }
        if (move.getStart() == null || move.getEnd() == null) {
            return false;
        }
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null || sourcePiece.getColor() != currentPlayerColor) {
            return false;
        }
        Piece destinationPiece = move.getEnd().getPiece();
        if (destinationPiece != null && destinationPiece.getColor() == currentPlayerColor) {
            return false;
        }
        return board.isValidMove(sourcePiece, move.getStart().getPosition(), move.getEnd().getPosition());
    }



    private void switchPlayer() {
        currentPlayerColor = currentPlayerColor == Color.WHITE ? Color.BLACK : Color.WHITE;
    }
}
