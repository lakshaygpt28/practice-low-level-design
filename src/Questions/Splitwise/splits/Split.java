package Questions.Splitwise.splits;

import Questions.Splitwise.User;

import java.math.BigDecimal;

public abstract class Split {
    User user;
    BigDecimal amount;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
