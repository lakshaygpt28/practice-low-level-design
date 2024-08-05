package Questions.Facebook.Dao;

import Questions.Facebook.Model.FriendRequest;
import Questions.Facebook.Model.Member;
import Questions.Facebook.Model.Notification;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FacebookDao {
    private Map<Integer, Member> members;
    private Map<Integer, List<FriendRequest>> pendingRequests;


    public FacebookDao() {
        members = new ConcurrentHashMap<>();
        pendingRequests = new ConcurrentHashMap<>();
    }

    public List<FriendRequest> getPendingRequests(int memberId) {
        pendingRequests.putIfAbsent(memberId, new CopyOnWriteArrayList<>());
        return pendingRequests.get(memberId);
    }

    public Map<Integer, Member> getMembers() {
        return members;
    }
}
