package Questions.Amazon.model;

import Questions.Amazon.util.IdGenerator;

public class User {
    private int id;
    String username;
    String name;
    String password;

    public User(String username, String password, String name) {
        this.id = IdGenerator.getNextId(User.class);
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
