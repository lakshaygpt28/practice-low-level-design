package Questions.FileStorageSystem.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class StorageSpace {
    String id;
    User owner;
    List<File> rootFiles;
    List<Folder> rootFolders;
    Long totalSpace;
    Long usedSpace;

    public StorageSpace(User owner, Long totalSpace) {
        this.id = UUID.randomUUID().toString();
        this.owner = owner;
        this.rootFiles = new ArrayList<>();
        this.rootFolders = new ArrayList<>();
        this.totalSpace = totalSpace;
        this.usedSpace = 0L;
    }

    public Folder getFolder(String folderName) {
        for (Folder folder : rootFolders) {
            if (folder.getName().equals(folderName)) {
                return folder;
            }
        }
        return new Folder(folderName);
    }
}
