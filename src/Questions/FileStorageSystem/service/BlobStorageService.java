package Questions.FileStorageSystem.service;

import Questions.FileStorageSystem.exception.ObjectNotFoundException;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BlobStorageService {
    private static BlobStorageService instance;
    private final Map<String, Byte[]> blobStore;

    BlobStorageService() {
        blobStore = new ConcurrentHashMap<>();
    }

    public static synchronized BlobStorageService getInstance() {
        if (instance == null) {
            instance = new BlobStorageService();
        }
        return instance;
    }

    public String uploadFile(Byte[] fileContent) {
        String uploadedFilePath = UUID.randomUUID().toString();
        blobStore.put(uploadedFilePath, fileContent);
        return uploadedFilePath;
    }

    public Byte[] downloadFile(String filePath) {
        if (!blobStore.containsKey(filePath)) {
            throw new ObjectNotFoundException("File Not found at key: " + filePath);
        }
        return blobStore.get(filePath);
    }
}
