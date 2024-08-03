package Questions.DigitalWallet.model;

import Questions.DigitalWallet.util.AccountIdGenerator;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

public class Account {
    private final int accountNumber;
    private final User user;
    private BigDecimal balance;
    private final Set<Transaction> transactions;

    public Account(User user, BigDecimal balance) {
        this.accountNumber = AccountIdGenerator.getNextId();
        this.user = user;
        this.balance = balance;
        transactions = new TreeSet<>((a, b) -> a.getId() - b.getId());
    }

    @Override
    public String toString() {
        return "Account [accountNumber= " + accountNumber + ", name=" + this.user.getName() + ", balance=" + balance  + ", transactions=" + transactions + "]";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void debit(BigDecimal transferAmount) {
        balance = balance.subtract(transferAmount);
    }

    public void credit(BigDecimal transferAmount) {
        balance = balance.add(transferAmount);
    }
}
