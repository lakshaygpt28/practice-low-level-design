package Questions.Splitwise.Expense;

import Questions.Splitwise.User;
import Questions.Splitwise.splits.Split;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(int id, String description, User paidBy, BigDecimal totalAmount, List<Split> splits) {
        super(id, description, paidBy, totalAmount, splits);
        split();
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void split() {
        int totalSplits = splits.size();

        BigDecimal splitAmount = totalAmount.divide(BigDecimal.valueOf(totalSplits), 2, RoundingMode.FLOOR);

        // Calculate the remainder
        BigDecimal totalSplitAmount = splitAmount.multiply(BigDecimal.valueOf(totalSplits));
        BigDecimal remainder = totalAmount.subtract(totalSplitAmount);

        // Assign the split amount to each split
        for (Split split : splits) {
            split.setAmount(splitAmount);
        }

        // Distribute the remainder
        if (remainder.compareTo(BigDecimal.ZERO) > 0) {
            splits.get(0).setAmount(splitAmount.add(remainder));
        }

    }

}
