package Questions.StackOverflow.model;

import java.util.ArrayList;
import java.util.List;

public class Answer extends TextPhotoBasedEntity {

    boolean isSolvedProblem;
    List<Comment> comments;

    public Answer(Long id, Member creator, String text, List<Photo> photos) {
        super(id, creator, text, photos);
        isSolvedProblem = false;
        comments = new ArrayList<>();
    }

    void markAsSolution() {
        isSolvedProblem = true;
    }

    public void updateText(String text) {
        this.text = text;
        lastUpdatedTime = System.currentTimeMillis();
    }

    public void receiveBounty(int reputation) {
        creator.receiveBounty(reputation);
    }

    public void addComment(Comment newComment) {
        comments.add(newComment);
    }

    public boolean isSolvedProblem() {
        return isSolvedProblem;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
