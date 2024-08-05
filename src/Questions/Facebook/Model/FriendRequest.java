package Questions.Facebook.Model;

public class FriendRequest {
    private Member requestFrom;
    private Member requestTo;
    private FriendRequestStatus status;

    public FriendRequest(Member requestFrom, Member requestTo) {
        this.requestFrom = requestFrom;
        this.requestTo = requestTo;
        this.status = FriendRequestStatus.PENDING;
    }

    public Member getRequestFrom() {
        return requestFrom;
    }

    public Member getRequestTo() {
        return requestTo;
    }

    public void accept() {
        requestFrom.getFriends().add(requestTo);
        requestTo.getFriends().add(requestFrom);
        this.status = FriendRequestStatus.ACCEPTED;
    }

    public void decline() {
        this.status = FriendRequestStatus.DECLINED;
    }
}
