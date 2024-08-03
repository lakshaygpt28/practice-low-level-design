package Questions.Splitwise.splits;

import Questions.Splitwise.User;

import java.math.BigDecimal;

public class ExactSplit extends Split {
    public ExactSplit(User user, BigDecimal shareAmount) {
        super(user);
        this.amount = shareAmount;
    }
}
