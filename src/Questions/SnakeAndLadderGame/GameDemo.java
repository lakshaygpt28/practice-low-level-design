package Questions.SnakeAndLadderGame;

import Questions.SnakeAndLadderGame.model.SnakeAndLadderGame;

import java.util.List;

public class GameDemo {
    public static void main(String[] args) {
        SnakeAndLadderGame game = new SnakeAndLadderGame(List.of("Lakshay", "Simran", "Rohit", "Shubhankar"));

        game.startGame();
    }
}
