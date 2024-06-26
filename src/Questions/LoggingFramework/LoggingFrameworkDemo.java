package Questions.LoggingFramework;

import Questions.LoggingFramework.LogAppender.Impl.FileAppender;

public class LoggingFrameworkDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.error("This is error messsage");

        logger.setConfig(new LoggerConfig(LogLevel.DEBUG, new FileAppender("logs.log")));
        logger.debug("This is again debug message");
        logger.fatal("This is fatal message");
        logger.warn("This is warn message");
    }
}
