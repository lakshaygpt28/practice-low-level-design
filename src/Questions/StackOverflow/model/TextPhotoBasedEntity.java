package Questions.StackOverflow.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class TextPhotoBasedEntity {
    Long id;
    String text;
    List<Photo> photos;
    Member creator;
    Set<Long> membersWhoUpVotedThisEntity;
    Set<Long> membersWhoDownVotedThisEntity;
    Status status;
    Set<Long> numberOfUsersReportedThisEntity;
    Long creationTime;
    Long lastUpdatedTime;

    public TextPhotoBasedEntity(Long id, Member creator, String text, List<Photo> photos) {
        this.id = id;
        this.creator = creator;
        this.text = text;
        this.photos = new ArrayList<>();
        status = Status.DEFAULT;

        if (photos != null) {
            this.photos = photos;
        }

        this.creationTime = System.currentTimeMillis();
        this.lastUpdatedTime = System.currentTimeMillis();
        this.membersWhoUpVotedThisEntity = new HashSet<>();
        this.membersWhoDownVotedThisEntity = new HashSet<>();
        this.numberOfUsersReportedThisEntity = new HashSet<>();;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TextPhotoBasedEntity) {
            return this.id == ((TextPhotoBasedEntity) obj).id;
        }
        return false;
    }

    public void upVote(Long memberId) {
        this.membersWhoUpVotedThisEntity.add(memberId);
        this.membersWhoDownVotedThisEntity.remove(memberId);
    }
    public void downVote(Long memberId) {
        this.membersWhoUpVotedThisEntity.add(memberId);
        this.membersWhoDownVotedThisEntity.remove(memberId);
    }

    void addPhotos(List<Photo> photos) {
        this.photos.addAll(photos);
        lastUpdatedTime = System.currentTimeMillis();
    }

    void removePhoto(List<Photo> photos) {
        this.photos.removeAll(photos);
        lastUpdatedTime = System.currentTimeMillis();
    }

    void report(Long memberId) {
        numberOfUsersReportedThisEntity.add(memberId);
    }

    public void delete() { // Admin can delete an entity
        status = Status.DELETED;
    }

    void updateText(String text) {
        this.text = text;
        lastUpdatedTime = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public Set<Long> getMembersWhoUpVotedThisEntity() {
        return membersWhoUpVotedThisEntity;
    }

    public Set<Long> getMembersWhoDownVotedThisEntity() {
        return membersWhoDownVotedThisEntity;
    }

    public Status getStatus() {
        return status;
    }

    public int getNumberOfUsersReportedThisEntity() {
        return numberOfUsersReportedThisEntity.size();
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public Long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public Member getCreator() {
        return this.creator;
    }

    public int getUpVoteCount() {
        return this.membersWhoUpVotedThisEntity.size();
    }

    public int getDownVoteCount() {
        return this.membersWhoDownVotedThisEntity.size();
    }

    public int getVoteCount() {
        return getUpVoteCount() - getDownVoteCount();
    }

}
