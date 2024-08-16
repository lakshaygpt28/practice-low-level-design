package Questions.SnakeAndLadderGame.model;

import java.util.Random;

public class Dice {
    private final Random random;

    public Dice() {
        random = new Random();
    }

    int roll() {
        System.out.println("Rolling dice......");
        return random.nextInt(1, 7);
    }
}
