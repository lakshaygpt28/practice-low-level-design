package Questions.Splitwise.Expense;

import Questions.Splitwise.User;
import Questions.Splitwise.splits.ExactSplit;
import Questions.Splitwise.splits.Split;

import java.math.BigDecimal;
import java.util.List;

public class ExactExpense extends Expense {
    public ExactExpense(int id, String description, User paidBy, BigDecimal totalAmount, List<Split> splits) {
        super(id, description, paidBy, totalAmount, splits);
    }

    @Override
    public boolean validate() {
        BigDecimal totalSplitsAmount = BigDecimal.ZERO;
        for (Split split : splits) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
            totalSplitsAmount.add(split.getAmount());
        }
        return totalSplitsAmount.equals(totalAmount);
    }
}
