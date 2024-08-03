package Questions.ATM;

public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(String transactionId, Account account, int amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.debit(amount);
    }
}
