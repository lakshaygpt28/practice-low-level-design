package Questions.FileStorageSystem.model;

import lombok.Getter;

@Getter
public class User {
    String username;
    String password;
    StorageSpace storageSpace;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void createStorageSpace(Long totalSpace) {
        if (storageSpace != null) {
            storageSpace = new StorageSpace(this, totalSpace);
        }
    }
}
