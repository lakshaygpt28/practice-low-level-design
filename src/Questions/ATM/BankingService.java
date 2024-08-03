package Questions.ATM;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String, Account> accounts;

    public BankingService() {
        accounts = new ConcurrentHashMap<>();
    }

    public void createAccount(String accountNumber, int initialAmount) {
        Account newAccount = new Account(accountNumber, initialAmount);
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exist!!!");
            return;
        }
        accounts.put(accountNumber, newAccount);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void processTransaction(Transaction transaction) {
        transaction.execute();
    }
}
