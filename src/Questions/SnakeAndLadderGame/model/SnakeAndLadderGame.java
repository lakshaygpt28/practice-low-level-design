package Questions.SnakeAndLadderGame.model;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {
    List<Player> players;
    Board board;
    Dice dice;
    int currentPlayerTurn;

    public SnakeAndLadderGame(List<String> playerNames) {
        board = new Board();
        dice = new Dice();
        players = new ArrayList<>();
        currentPlayerTurn = 0;
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    public void startGame() {
        System.out.println("New Game Started....");
        while (!isGameOver()) {
            Player currentPlayer = players.get(currentPlayerTurn);
            System.out.println("Player: " + currentPlayer.getName() + " please roll the dice...");
            int rolledDice = dice.roll();
            if (rolledDice == 6) {
                if (currentPlayer.getCurrentPosition() == 0) {
                    currentPlayer.setCurrentPosition(1);
                } else {
                    int newPosition = currentPlayer.getCurrentPosition() + rolledDice;
                    if (newPosition <= board.getBoardSize()) {
                        currentPlayer.setCurrentPosition(board.getNewPositionAfterSnakeOrLadder(newPosition));
                    }
                }
                System.out.println(currentPlayer.getName() + " rolled a " + rolledDice +
                        " and moved to position " + currentPlayer.getCurrentPosition());
                // samePlayer turn until he throws 6;
            } else {
                if (currentPlayer.getCurrentPosition() != 0) {
                    int newPosition = currentPlayer.getCurrentPosition() + rolledDice;
                    if (newPosition <= board.getBoardSize()) {
                        currentPlayer.setCurrentPosition(board.getNewPositionAfterSnakeOrLadder(newPosition));
                    }
                } else {
                    System.out.println("You need to roll 6 for starting the game....");
                }
                System.out.println(currentPlayer.getName() + " rolled a " + rolledDice +
                        " and moved to position " + currentPlayer.getCurrentPosition());
                nextPlayerTurn();
            }

        }
    }

    private void nextPlayerTurn() {
        System.out.println("----------------------");
        System.out.println("Next Player Turn");
        currentPlayerTurn = (currentPlayerTurn + 1) % players.size();
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getCurrentPosition() == board.getBoardSize()) {
                System.out.println("Player: " + player.getName() + " has won the game!!!");
                return true;
            }
        }
        return false;
    }
}
