package Questions.Facebook.Model;

public class Notification {
    private NotificationType notificationType;
    private Member recipient;
    private String message;

    public Notification(NotificationType notificationType, Member recipient, String message) {
        this.notificationType = notificationType;
        this.recipient = recipient;
        this.message = message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public Member getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationType=" + notificationType +
                ", recipient=" + recipient.getName() +
                ", message='" + message + '\'' +
                '}';
    }
}
