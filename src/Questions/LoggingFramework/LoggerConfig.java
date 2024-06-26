package Questions.LoggingFramework;

import Questions.LoggingFramework.LogAppender.LogAppender;

public class LoggerConfig {

    private final LogLevel logLevel;
    private final LogAppender logAppender;

    public LoggerConfig(LogLevel logLevel, LogAppender logAppender) {
        this.logLevel = logLevel;
        this.logAppender = logAppender;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }
}

