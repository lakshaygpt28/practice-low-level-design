package Questions.ATM;

import java.util.UUID;

public class ATM {
    CashDispenser cashDispenser;
    BankingService bankingService;

    public ATM(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public void authenticateCard(Card card) {

    }

    public int checkBalance(String accountNumber) {
        Account account = bankingService.getAccount(accountNumber);
        return account.getBalanceAmount();
    }


    public void withdrawCash(String accountNumber, int amount) {
        Account account = bankingService.getAccount(accountNumber);
        Transaction transaction = new WithdrawTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash(amount);
    }

    public void depositCash(String accountNumber, int amount) {
        Account account = bankingService.getAccount(accountNumber);
        Transaction transaction = new DepositTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
    }

    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
