package Questions.ATM;

public abstract class Transaction {
    protected Account account;
    protected int amount;
    protected String transactionId;

    public Transaction(String transactionId, Account account, int amount) {
        this.account = account;
        this.amount = amount;
        this.transactionId = transactionId;
    }

    public void execute() {}
}
