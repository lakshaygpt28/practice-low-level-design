package Questions.Splitwise.splits;

import Questions.Splitwise.User;

public class PercentSplit extends Split {
    double sharePercent;

    public PercentSplit(User user, double sharePercent) {
        super(user);
        this.sharePercent = sharePercent;
    }

    public double getSharePercent() {
        return sharePercent;
    }
}
