package Questions.DigitalWallet.util;

public class TransactionIdGenerator {
    private static int id = 1;

    public static int getNextId() {
        return id++;
    }
}
