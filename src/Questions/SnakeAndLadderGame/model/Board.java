package Questions.SnakeAndLadderGame.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final static int BOARD_SIZE = 100;
    private Map<Integer, Snake> snakes;
    private Map<Integer, Ladder> ladders;

    public Board() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        initializeSnakesAndLadders();
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    private void initializeSnakesAndLadders() {
        // Initialize snakes
        snakes.put(16, new Snake(16, 6));
        snakes.put(48, new Snake(48, 26));
        snakes.put(64, new Snake(64, 60));
        snakes.put(93, new Snake(93, 73));

        // Initialize ladders
        ladders.put(1, new Ladder(1, 38));
        ladders.put(4, new Ladder(4, 14));
        ladders.put(9, new Ladder(9, 31));
        ladders.put(21, new Ladder(21, 42));
        ladders.put(28, new Ladder(28, 84));
        ladders.put(51, new Ladder(51, 67));
        ladders.put(80, new Ladder(80, 99));
    }

    public int getNewPositionAfterSnakeOrLadder(int position) {
        if (snakes.containsKey(position)) {
            System.out.println("Oops, you got hit by the snake....");
            return snakes.get(position).getEndPosition();
        }
        if (ladders.containsKey(position)) {
            System.out.println("Yay, you climbed the ladder...");
            return ladders.get(position).getEndPosition();
        }
        return position;
    }

}
