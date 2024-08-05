package Questions.Facebook.Model;

import Questions.Facebook.Util.IdGenerator;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Post {
    private int id;
    private Member createdBy;
    private List<String> mediaURLs;
    private String caption;
    private List<Integer> likes;
    private List<Comment> comments;
    private Date createdOn;

    public Post(Member createdBy, List<String> mediaURLs, String caption) {
        this.id = IdGenerator.getNextId(Post.class);
        this.createdBy = createdBy;
        this.mediaURLs = mediaURLs;
        this.caption = caption;
        likes = new CopyOnWriteArrayList<>();
        comments = new CopyOnWriteArrayList<>();
        createdOn = new Date();
    }

    @Override
    public String toString() {
        return "Post{" +
                "caption='" + caption + '\'' +
                ", likes=" + likes.size() +
                ", comments=" + comments +
                '}';
    }

    public Member getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Integer> getLikes() {
        return likes;
    }
}
