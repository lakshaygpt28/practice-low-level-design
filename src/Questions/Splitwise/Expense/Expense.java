package Questions.Splitwise.Expense;

import Questions.Splitwise.User;
import Questions.Splitwise.splits.Split;

import java.math.BigDecimal;
import java.util.List;

public abstract class Expense {
    int id;
    String description;
    User paidBy;
    BigDecimal totalAmount;
    List<Split> splits;

    public Expense(int id, String description, User paidBy, BigDecimal totalAmount, List<Split> splits) {
        this.id = id;
        this.description = description;
        this.paidBy = paidBy;
        this.totalAmount = totalAmount;
        this.splits = splits;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public abstract boolean validate();

    public void split() {}


}

