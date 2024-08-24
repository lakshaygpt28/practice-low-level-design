package Questions.FileStorageSystem.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Folder {
    private final String id;
    private String name;
    private List<File> files;
    private List<Folder> subFolders;

    public Folder(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.files = new ArrayList<>();
        this.subFolders = new ArrayList<>();
    }

    public File getFile(String fileName) {
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    public void addFile(File file) {
        files.add(file);
    }
}
