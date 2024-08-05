package Questions.Facebook.Service;

import Questions.Facebook.Dao.FacebookDao;
import Questions.Facebook.Model.*;

import java.util.ArrayList;
import java.util.List;

public class FacebookService {

    private final FacebookDao facebookDao;
    private final NotificationService notificationService;

    public FacebookService() {
        facebookDao = new FacebookDao();
        notificationService = new NotificationService();
    }

    public void createPost(Post post) {
        Member createdBy = post.getCreatedBy();
        createdBy.getPosts().add(post);
    }

    public void sendFriendRequest(Member requestFrom, Member requestTo) {
        FriendRequest friendRequest = new FriendRequest(requestFrom, requestTo);
        facebookDao.getPendingRequests(requestTo.getId()).add(friendRequest);

        Notification notification = new Notification(
                NotificationType.FRIEND_REQUEST,
                requestTo,
                requestFrom.getName() + " has sent you a friend request.");
        notificationService.sendNotification(notification);
    }

    public List<FriendRequest> getPendingRequests(Member member) {
        return facebookDao.getPendingRequests(member.getId());
    }

    public void acceptFriendRequest(FriendRequest friendRequest) {
        friendRequest.accept();
        Notification notification = new Notification(
                NotificationType.FRIEND_REQUEST_ACCEPTED,
                friendRequest.getRequestFrom(),
                friendRequest.getRequestTo().getName() + " has accepted your friend request.");
        notificationService.sendNotification(notification);
        facebookDao.getPendingRequests(friendRequest.getRequestTo().getId()).remove(friendRequest);
    }

    public void declineFriendRequest(FriendRequest friendRequest) {
        friendRequest.decline();
        facebookDao.getPendingRequests(friendRequest.getRequestTo().getId()).remove(friendRequest);
    }

    public void likePost(Post post, Member likedBy) {
        post.getLikes().add(likedBy.getId());
        Notification notification = new Notification(
                NotificationType.LIKE,
                post.getCreatedBy(),
                likedBy.getName() + " liked your post."
        );
        notificationService.sendNotification(notification);
    }

    public void commentOnPost(Post post, Member commentedBy, String commentStr) {
        Comment comment = new Comment(post, commentedBy, commentStr);
        post.getComments().add(comment);
        Notification notification = new Notification(
                NotificationType.COMMENT,
                post.getCreatedBy(),
                commentedBy.getName() + " commented on your post: " + commentStr
        );
        notificationService.sendNotification(notification);
    }

    public List<Post> getFeed(Member member) {
        List<Post> feed = new ArrayList<>();
        for (Member friends : member.getFriends()) {
            feed.addAll(friends.getPosts());
        }
        feed.sort((a, b) -> (b.getCreatedOn().compareTo(a.getCreatedOn())));
        return feed;
    }

    public void checkNotifications(Member member) {
        System.out.println("Getting all notifications for :" + member.getName());
        List<Notification> notifications = notificationService.getAllNotifications(member);
        for (Notification notification: notifications) {
            System.out.println(notification.getMessage());
        }
    }


}
