package Questions.StackOverflow.model;

public class Member {

    public enum AccountStatus{
        ACTIVE,
        CLOSED,
        CANCELED,
        BLACKLISTED,
        BLOCKED
    }
    private Long id;

    AccountStatus accountStatus;
    String name;
    String displayName;
    String email;


    boolean isModerator;
    boolean isAdmin;
    int reputation;

    public Member(long id) {
        this.id = id;
        accountStatus = AccountStatus.ACTIVE;
    }

    void promoteToModerator() {
        isModerator = true;
    }

    void promoteToAdmin() {
        isAdmin = true;
    }

    public void closeAccount() {
        accountStatus = AccountStatus.CLOSED;
    }

    public void cancelAccount() {
        accountStatus = AccountStatus.CANCELED;
    }

    public void blacklist() {
        accountStatus = AccountStatus.BLACKLISTED;
    }

    public void block() {
        accountStatus = AccountStatus.BLOCKED;
    }

    public boolean blockMember(Member member) {
        if (isAdmin) {
            member.block();
            return true;
        }
        return false;
    }

    public boolean unblockMember(Member member) {
        if (isAdmin) {
            member.accountStatus = AccountStatus.ACTIVE;
            return true;
        }
        return false;
    }

    public boolean closeQuestion(Question question) {
        if (isAdmin || isModerator || this.id == question.getCreator().getId()) {
            question.close();
            return true;
        }
        return false;
    }

    public boolean giveBountyTo(int bountyReputation, Member receiver) {
        if (reputation >= bountyReputation && this.id != receiver.getId()) {
            reputation -= bountyReputation;
            receiver.receiveBounty(bountyReputation);
            return true;
        }
        return false;
    }

    public void receiveBounty(int bountyReputation) {
        reputation += bountyReputation;
    }

    public Long getId() {
        return id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }
}
