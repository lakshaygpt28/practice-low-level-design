package Questions.Facebook.Model;

import Questions.Facebook.Util.IdGenerator;

public class Comment {
    private int id;
    private Post post;
    private Member commentedBy;
    private String comment;

    public Comment(Post post, Member commentedBy, String comment) {
        this.id = IdGenerator.getNextId(Comment.class);
        this.post = post;
        this.commentedBy = commentedBy;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentedBy=" + commentedBy.getName() +
                ", comment='" + comment + '\'' +
                '}';
    }
}
