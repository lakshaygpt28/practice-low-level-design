package Questions.StackOverflow.model;

import java.util.ArrayList;
import java.util.List;

public class Question extends TextPhotoBasedEntity {
    String title;
    Bounty bounty;
    List<Answer> answers;
    List<Comment> comments;
    List<Tag> tags;

    public Question(Long id, Member creator, String title, String text, List<Photo> photos, List<Tag> tags, Bounty bounty) {
        super(id, creator, text, photos);
        this.title = title;
        this.bounty = bounty;
        status = Status.OPEN;

        if (tags != null) {
            this.tags = tags;
        } else {
            this.tags = new ArrayList<>();
        }
        comments = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public void close() {
        status = Status.CLOSED;
    }

    public void addComment(Comment newComment) {
        comments.add(newComment);
    }

    public void addAnswer(Answer newAnswer) {
        answers.add(newAnswer);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public String getTitle() {
        return title;
    }

    public Bounty getBounty() {
        return bounty;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public Status getStatus() {
        return super.getStatus();
    }
}
