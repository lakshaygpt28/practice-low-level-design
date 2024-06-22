package Questions.StackOverflow.model;

import java.util.List;

public class Comment extends TextPhotoBasedEntity {
    public Comment(Long id, Member creator, String text, List<Photo> photos) {
        super(id, creator, text, photos);
    }
}
