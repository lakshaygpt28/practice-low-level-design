package Questions.LoggingFramework.LogAppender;

import Questions.LoggingFramework.LogMessage;

public interface LogAppender {

    public void append(LogMessage logMessage);
}
