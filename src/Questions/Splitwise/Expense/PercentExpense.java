package Questions.Splitwise.Expense;

import Questions.Splitwise.User;
import Questions.Splitwise.splits.PercentSplit;
import Questions.Splitwise.splits.Split;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PercentExpense extends Expense {
    public PercentExpense(int id, String description, User paidBy, BigDecimal totalAmount, List<Split> splits) {
        super(id, description, paidBy, totalAmount, splits);
        split();
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void split() {
        for (Split split : splits) {
            PercentSplit percentSplit = (PercentSplit) split;
            BigDecimal percent = BigDecimal.valueOf(percentSplit.getSharePercent());
            BigDecimal splitAmount = totalAmount.multiply(percent)
                    .divide(new BigDecimal(100), 2, RoundingMode.FLOOR);
            split.setAmount(splitAmount);
        }
    }
}
