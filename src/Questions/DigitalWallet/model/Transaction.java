package Questions.DigitalWallet.model;

import Questions.DigitalWallet.util.TransactionIdGenerator;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private final int id;
    private final int debitAccountNumber;
    private final int creditAccountNumber;
    private final BigDecimal amount;
    private final Date date;

    public Transaction(int debitAccountNumber, int creditAccountNumber, BigDecimal amount) {
        this.id = TransactionIdGenerator.getNextId();
        this.debitAccountNumber = debitAccountNumber;
        this.creditAccountNumber = creditAccountNumber;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", debitAccount=" + debitAccountNumber +
                ", creditAccount=" + creditAccountNumber +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}
