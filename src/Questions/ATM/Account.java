package Questions.ATM;

public class Account {
    private final String accountNumber;
    private int balanceAmount;

    public Account(String accountNumber, int initialAmount) {
        this.accountNumber = accountNumber;
        this.balanceAmount = initialAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalanceAmount() {
        return balanceAmount;
    }

    void debit(int amount) {
        balanceAmount -= amount;
    }

    void credit(int amount) {
        balanceAmount += amount;
    }
}
