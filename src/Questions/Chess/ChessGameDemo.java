package Questions.Chess;

import Questions.Chess.model.Color;
import Questions.Chess.model.Player;
import Questions.Chess.model.Position;

public class ChessGameDemo {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", Color.WHITE);
        Player player2 = new Player("Bob", Color.BLACK);
        ChessGame game = new ChessGame(player1, player2);

        game.makeMove(player1, new Position(1,3), new Position(3, 3));
        game.makeMove(player2, new Position(6,4), new Position(5, 4));
    }
}
