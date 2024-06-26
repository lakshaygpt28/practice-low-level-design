package Questions.LoggingFramework.LogAppender.Impl;

import Questions.LoggingFramework.LogAppender.LogAppender;
import Questions.LoggingFramework.LogMessage;

public class ConsoleAppender implements LogAppender {
    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage);
    }
}
