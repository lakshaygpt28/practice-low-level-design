package Questions.Splitwise;

import Questions.Splitwise.splits.EqualSplit;
import Questions.Splitwise.splits.PercentSplit;
import Questions.Splitwise.splits.Split;

import java.util.List;

public class SplitwiseDemo {
    public static void main(String[] args) {
        SplitwiseService splitwiseService = new SplitwiseService();

        User user1 = new User(1, "Lakshay");
        User user2 = new User(2, "Simran");
        User user3 = new User(3, "Rohit");
        splitwiseService.addUser(user1);
        splitwiseService.addUser(user2);
        splitwiseService.addUser(user3);

        Group group1 = new Group(1, "Prestige folks");

        Split split1 = new EqualSplit(user1);
        Split split2 = new EqualSplit(user2);
        Split split3 = new EqualSplit(user3);
        List<Split> splits1 = List.of(split1, split2, split3);

        splitwiseService.addExpense(ExpenseType.EQUAL, "Zepto", 1, 100.00, splits1);
        splitwiseService.getBalance(1);

        Split split4 = new PercentSplit(user1, 10);
        Split split5 = new PercentSplit(user2, 20);
        Split split6 = new PercentSplit(user3, 70);
        List<Split> splits2 = List.of(split4, split5, split6);
        splitwiseService.addExpense(ExpenseType.PERCENT, "Big Basket", 2, 200.00, splits2);
        splitwiseService.getBalances();
    }
}
