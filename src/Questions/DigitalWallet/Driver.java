package Questions.DigitalWallet;

import Questions.DigitalWallet.model.Account;
import Questions.DigitalWallet.model.User;
import Questions.DigitalWallet.service.WalletService;

import java.math.BigDecimal;

public class Driver {
    public static void main(String[] args) {
        User user1 = new User(1, "Lakshay");
        User user2 = new User(1, "Simran");

        WalletService walletService = new WalletService();

        Account account1 = walletService.createAccount(user1, 1000.00);
        Account account2 = walletService.createAccount(user2, 500.00);

        walletService.transfer(account1.getAccountNumber(), account2.getAccountNumber(), BigDecimal.valueOf(250.00));
        walletService.transfer(account2.getAccountNumber(), account1.getAccountNumber(), BigDecimal.valueOf(600.00));

        walletService.statement(account1.getAccountNumber());
        walletService.statement(account2.getAccountNumber());

    }
}
