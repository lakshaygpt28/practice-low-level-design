package Questions.Facebook.Dao;

import Questions.Facebook.Model.Notification;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationDao {
    private Map<Integer, List<Notification>> notifications;

    public NotificationDao() {
        notifications = new ConcurrentHashMap<>();
    }

    public List<Notification> getNotifications(int memberId) {
        notifications.putIfAbsent(memberId, new CopyOnWriteArrayList<>());
        return notifications.get(memberId);
    }
}
