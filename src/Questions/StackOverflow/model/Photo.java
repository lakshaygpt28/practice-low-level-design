package Questions.StackOverflow.model;

public class Photo {
    Long id;
    String photoPath;
    Member creatingMember;
    Long creationTime;

    Photo(Long id, String photoPath, Member creatingMember) {
        this.id = id;
        this.photoPath = photoPath;
        this.creatingMember = creatingMember;
        this.creationTime = System.currentTimeMillis();
    }

    public boolean equals(Object o) {
        if (o instanceof Photo) {
            return this.id == ((Photo)o).id;
        }
        return false;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public Member getCreatingMember() {
        return creatingMember;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public Long getId() {
        return this.id;
    }
}
