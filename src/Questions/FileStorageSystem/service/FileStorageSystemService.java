package Questions.FileStorageSystem.service;

import Questions.FileStorageSystem.exception.ObjectNotFoundException;
import Questions.FileStorageSystem.model.File;
import Questions.FileStorageSystem.model.Folder;
import Questions.FileStorageSystem.model.StorageSpace;
import Questions.FileStorageSystem.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileStorageSystemService {
    BlobStorageService blobStorageService;
    Map<String, User> users;

    public FileStorageSystemService() {
        blobStorageService = BlobStorageService.getInstance();
        users = new ConcurrentHashMap<>();
    }

    public User registerUser(String userName, String password) {
        if (users.containsKey(userName)) {
            System.out.println("User already exist. Please login");
            return null;
        }
        User user = new User(userName, password);
        users.put(userName, user);
        return user;
    }

    public User login(String userName, String password) {
        if (!users.containsKey(userName)) {
            System.out.println("User does not exist. Please register");
            return null;
        }
        User user = users.get(userName);
        if (!password.equals(user.getPassword())) {
            System.out.println("Incorrect Password");
            return null;
        }
        System.out.println("Login Successfully");
        return user;
    }

    boolean uploadFile(User user, String folderName, String fileName, Byte[] fileData) {
        Long fileSize = (long) fileData.length;
        StorageSpace storageSpace = user.getStorageSpace();
        if (fileSize + storageSpace.getUsedSpace() > storageSpace.getTotalSpace()) {
            System.out.println("Not enough storage. Please upgrade");
            return false;
        }
        String uploadedFilePath = blobStorageService.uploadFile(fileData);
        Folder folder = storageSpace.getFolder(folderName);
        File file = folder.getFile(fileName);
        if (file != null) { // update Version
            file.addNewVersion(uploadedFilePath, fileSize);
        } else {
            file = new File(fileName, uploadedFilePath, fileSize);
            folder.addFile(file);
        }
        System.out.println("File uploaded to storage space.");
        return true;
    }

    Byte[] downloadFile(User user, String folderName, String fileName) {
        StorageSpace storageSpace = user.getStorageSpace();
        Folder folder = storageSpace.getFolder(folderName);
        if (folder == null) {
            System.out.println("Folder doesn't exit.");
            return null;
        }
        File file = folder.getFile(fileName);
        if (file == null) {
            System.out.println("File doesn't exit.");
            return null;
        }
        try {
            return blobStorageService.downloadFile(file.getLatestVersion());
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
