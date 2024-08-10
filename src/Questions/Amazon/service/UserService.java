package Questions.Amazon.service;

import Questions.Amazon.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    private final Map<String, User> users;

    public UserService() {
        users = new ConcurrentHashMap<>();
    }

    public User register(String username, String password, String name) {
        User user = new User(username, password, name);
        users.put(username, user);
        return user;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("User not found with username: " + username);
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        System.out.println("Incorrect password. Try Again!!!");
        return null;
    }
}
