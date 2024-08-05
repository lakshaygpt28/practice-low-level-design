package Questions.Facebook;

import Questions.Facebook.Model.Account;
import Questions.Facebook.Model.FriendRequest;
import Questions.Facebook.Model.Member;
import Questions.Facebook.Model.Post;
import Questions.Facebook.Service.FacebookService;

import java.util.ArrayList;
import java.util.List;

public class FacebookDemo {
    public static void main(String[] args) {

        FacebookService facebookService = new FacebookService();

        Member member1 = new Member("Lakshay Gupta", new Account("lakshaygpt28", "weakPassword123"));
        Member member2 = new Member("Simran Chawla", new Account("chawlasim212", "strongPassword456"));

        Post post1 = new Post(member1, new ArrayList<>(), "My First Post");
        Post post2 = new Post(member1, new ArrayList<>(), "My Second Post");

        facebookService.createPost(post1);
        facebookService.createPost(post2);

        facebookService.sendFriendRequest(member1, member2);

        FriendRequest recentFriendRequest = facebookService.getPendingRequests(member2).get(0);
        facebookService.acceptFriendRequest(recentFriendRequest);

        facebookService.likePost(post1, member2);
        facebookService.likePost(post1, member1);

        facebookService.commentOnPost(post1, member2, "Nice pic dear!!!");

        List<Post> feed = facebookService.getFeed(member2);
        System.out.println("Getting feed for: " + member2.getName());
        for (Post post : feed) {
            System.out.println(post);
        }

        feed = facebookService.getFeed(member1);
        System.out.println("Getting feed for: " + member1.getName());
        for (Post post : feed) {
            System.out.println(post);
        }


        facebookService.checkNotifications(member1);
        facebookService.checkNotifications(member2);

    }
}
