package Questions.FileStorageSystem.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class File {
    private final String id;
    private final String name;
    private final List<String> versions;
    private Long totalSize;

    public File(String name, String firstVersionFilePath, Long fileSize) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.versions = new ArrayList<>();
        this.versions.add(firstVersionFilePath);
        this.totalSize = fileSize;
    }

    public void addNewVersion(String firstVersionFilePath, Long fileSize) {
        versions.add(firstVersionFilePath);
        totalSize += fileSize;
    }

    public String getLatestVersion() {
        return versions.get(versions.size() - 1);
    }

    public String getVersion(int versionNumber) {
        return versions.get(versionNumber);
    }

}
