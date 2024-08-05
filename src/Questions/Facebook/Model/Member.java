package Questions.Facebook.Model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Member extends User {
    private List<Member> friends;
    private List<Post> posts;

    public Member(String name, Account account) {
        super(name, account);
        friends = new CopyOnWriteArrayList<>();
        posts = new CopyOnWriteArrayList<>();
    }

    public List<Member> getFriends() {
        return friends;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
