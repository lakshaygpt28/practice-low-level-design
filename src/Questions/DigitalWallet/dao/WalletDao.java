package Questions.DigitalWallet.dao;

import Questions.DigitalWallet.model.Account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WalletDao {
    Map<Integer, Account> accountMap;

    public WalletDao() {
        accountMap = new ConcurrentHashMap<>();
    }

    public Map<Integer, Account> getAccountMap() {
        return accountMap;
    }
}
