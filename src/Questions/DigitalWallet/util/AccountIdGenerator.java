package Questions.DigitalWallet.util;

public class AccountIdGenerator {
    private static int id = 1;

    public static int getNextId() {
        return id++;
    }
}
