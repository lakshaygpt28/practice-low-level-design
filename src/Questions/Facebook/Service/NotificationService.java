package Questions.Facebook.Service;

import Questions.Facebook.Dao.NotificationDao;
import Questions.Facebook.Model.Member;
import Questions.Facebook.Model.Notification;

import java.util.List;

public class NotificationService {
    private NotificationDao notificationDao;

    public NotificationService() {
        notificationDao = new NotificationDao();
    }

    public void sendNotification(Notification notification) {
        notificationDao.getNotifications(notification.getRecipient().getId()).add(notification);
        System.out.println("Notification sent to " + notification.getRecipient().getName() + ": " + notification.getMessage());
    }

    public List<Notification> getAllNotifications(Member member) {
        return notificationDao.getNotifications(member.getId());
    }
}
