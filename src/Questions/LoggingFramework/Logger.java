package Questions.LoggingFramework;

import Questions.LoggingFramework.LogAppender.Impl.ConsoleAppender;

public class Logger {
    private volatile static Logger logger;
    private LoggerConfig config;

    Logger() {
        config = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void setConfig(LoggerConfig config) {
        this.config = config;
    }

    void log(LogLevel logLevel, String message) {
        if (logLevel.ordinal() >= config.getLogLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(logLevel, message);
            config.getLogAppender().append(logMessage);
        }
    }

    void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    void info(String message) {
        log(LogLevel.INFO, message);
    }

    void warn(String message) {
        log(LogLevel.WARN, message);
    }

    void error(String message) {
        log(LogLevel.ERROR, message);
    }

    void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
