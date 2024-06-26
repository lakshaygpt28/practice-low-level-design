package Questions.LoggingFramework.LogAppender.Impl;

import Questions.LoggingFramework.LogAppender.LogAppender;
import Questions.LoggingFramework.LogMessage;

import java.io.File;
import java.io.FileWriter;

public class FileAppender implements LogAppender {
    String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public void append(LogMessage logMessage) {
        try(FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(logMessage.toString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
