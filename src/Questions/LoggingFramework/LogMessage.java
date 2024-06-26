package Questions.LoggingFramework;

public class LogMessage {
    private final LogLevel logLevel;
    private final String message;
    private final Long timeStamp;

    public LogMessage(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "[" + logLevel.name() + "] " + timeStamp + " - " + message;
    }
}
