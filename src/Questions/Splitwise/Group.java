package Questions.Splitwise;

import Questions.Splitwise.Expense.Expense;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group {
    int id;
    String name;
    List<Expense> expenses;
    List<User> members;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.expenses = new CopyOnWriteArrayList<>();
        this.members = new CopyOnWriteArrayList<>();
    }

    public void addExpense() {

    }

    public void addMember(User user) {
        members.add(user);
    }
}
