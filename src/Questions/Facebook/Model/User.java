package Questions.Facebook.Model;


import Questions.Facebook.Util.IdGenerator;

public class User {
    private int id;
    private String name;
    private Account account;

    public User(String name, Account account) {
        this.id = IdGenerator.getNextId(User.class);
        this.name = name;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
