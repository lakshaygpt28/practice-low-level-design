package Questions.StackOverflow.model;

public class Bounty {
    int reputation;
    Long expirationDate;

    public Bounty(int reputation, Long expirationDate) {
        this.reputation = reputation;
        this.expirationDate = expirationDate;
    }

    public void modifyReputation(int reputation) {
        this.reputation = reputation;
    }
}
