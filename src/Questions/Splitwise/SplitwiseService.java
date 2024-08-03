package Questions.Splitwise;

import Questions.Splitwise.Expense.EqualExpense;
import Questions.Splitwise.Expense.ExactExpense;
import Questions.Splitwise.Expense.Expense;
import Questions.Splitwise.Expense.PercentExpense;
import Questions.Splitwise.splits.Split;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SplitwiseService {
    private static final AtomicInteger counter = new AtomicInteger();
    Map<Integer, Expense> expenses;
    Map<Integer, User> users;
    Map<Integer, Group> groups;

    public SplitwiseService() {
        users = new ConcurrentHashMap<>();
        groups = new ConcurrentHashMap<>();
        expenses = new ConcurrentHashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }


    public void addExpense(ExpenseType expenseType, String description, int paidByUserId, double totalAmount, List<Split> splits) {
        User paidBy = users.get(paidByUserId);
        Expense expense = switch (expenseType) {
            case EXACT ->
                new ExactExpense(getExpenseId(), description, paidBy, new BigDecimal(totalAmount), splits);
            case EQUAL ->
                new EqualExpense(getExpenseId(), description, paidBy, new BigDecimal(totalAmount), splits);
            case PERCENT ->
                new PercentExpense(getExpenseId(), description, paidBy, new BigDecimal(totalAmount), splits);
        };
        expenses.put(expense.getId(), expense);
        updateBalances(expense);
    }

    private void updateBalances(Expense expense) {
        User paidBy = expense.getPaidBy();
        for (Split split : expense.getSplits()) {
            User paidTo = split.getUser();
            Map<Integer, BigDecimal> balances = paidBy.getBalances();
            balances.putIfAbsent(paidTo.getId(), BigDecimal.ZERO);
            balances.put(paidTo.getId(), balances.get(paidTo.getId()).add(split.getAmount()));

            balances = paidTo.getBalances();
            balances.putIfAbsent(paidBy.getId(), BigDecimal.ZERO);
            balances.put(paidBy.getId(), balances.get(paidBy.getId()).subtract(split.getAmount()));
        }
    }


    private static int getExpenseId() {
        return counter.incrementAndGet();
    }

    public void getBalance(int userId) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User Not Found!!");
            return;
        }
        Map<Integer, BigDecimal> balances = user.getBalances();
        for (int otherUserId : balances.keySet()) {
            BigDecimal amount = balances.get(otherUserId);
            if (amount.compareTo(BigDecimal.ZERO) != 0) {
                printBalance(userId, otherUserId, amount);
            }
        }
    }

    public void getBalances() {
        for (User user : users.values()) {
            Map<Integer, BigDecimal> balances = user.getBalances();
            for (int otherUserId : balances.keySet()) {
                BigDecimal amount = balances.get(otherUserId);
                if (amount.compareTo(BigDecimal.ZERO) > 0) {
                    printBalance(user.getId(), otherUserId, amount);
                }
            }
        }
    }

    private void printBalance(int user1, int user2, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println( "User: " + user1 + " will get $" + amount + " from User: " + user2);
        } else if (amount.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println( "User: " + user1 + " needs to give $" + amount.abs() + " to User: " + user2);
        } else {
            System.out.println("All settled up between User: " + user1 + " and User: " + user2);
        }
    }
}
