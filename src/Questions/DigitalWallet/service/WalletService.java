package Questions.DigitalWallet.service;

import Questions.DigitalWallet.dao.WalletDao;
import Questions.DigitalWallet.model.Account;
import Questions.DigitalWallet.model.Transaction;
import Questions.DigitalWallet.model.User;

import java.math.BigDecimal;

public class WalletService {
    private final WalletDao walletDao;

    public WalletService() {
        walletDao = new WalletDao();
    }

    public Account createAccount(User user, double initialAmount) {
        Account account = new Account(user, BigDecimal.valueOf(initialAmount));
        walletDao.getAccountMap().put(account.getAccountNumber(), account);
        System.out.println("Account created for user: " + user.getName() + " with account number " + account.getAccountNumber());
        return account;
    }

    public void transfer(int debitAccountNumber, int creditAccountNumber, BigDecimal transferAmount) {
        if (!validate(debitAccountNumber, creditAccountNumber, transferAmount)) {
            return;
        }
        Account debitAccount = walletDao.getAccountMap().get(debitAccountNumber);
        Account creditAccount = walletDao.getAccountMap().get(creditAccountNumber);

        if (debitAccount.getBalance().compareTo(transferAmount) < 0) {
            System.out.println("Insufficient Balance!!!");
            return;
        }
        Transaction transaction = new Transaction(debitAccountNumber, creditAccountNumber, transferAmount);
        debitAccount.debit(transferAmount);
        creditAccount.credit(transferAmount);
        debitAccount.getTransactions().add(transaction);
        creditAccount.getTransactions().add(transaction);
        System.out.println("Transfer Successful!!!");
    }

    private boolean validate( int debitAccountNumber, int creditAccountNumber, BigDecimal transferAmount) {
        if (debitAccountNumber == creditAccountNumber) {
            System.out.println("Sender and Receiver cannot be same.");
            return false;
        } else if (transferAmount.compareTo(BigDecimal.valueOf(0.0001)) < 0) {
            System.out.println("Transfer amount too low.");
            return false;
        } else if (!walletDao.getAccountMap().containsKey(debitAccountNumber)) {
            System.out.println("Invalid debit account");
            return false;
        } else if (!walletDao.getAccountMap().containsKey(creditAccountNumber)) {
            System.out.println("Invalid credit account");
            return false;
        }
        return true;
    }

    public void statement(int accountNum) {
        Account account = walletDao.getAccountMap().get(accountNum);
        if (account == null) {
            System.out.println("Invalid Account Number");
            return;
        }
        System.out.println("Summary for account number: " + accountNum);
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("Your Transaction History");
        System.out.println(account.getTransactions());
    }
}

