package Questions.PubSubSystem;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Publisher {
    private final int id;
    private final Set<Topic> topics;

    public Publisher(int id) {
        this.id = id;
        topics = new CopyOnWriteArraySet<>();
    }

    void publish(Topic topic, Message message) {
        if (topics.contains(topic)) {
            topic.publish(message);
        } else {
            System.out.println("Publisher: " + id + " cannot publish message to the topic: " + topic.getName());
        }
    }

    void addTopic(Topic topic) {
        topics.add(topic);
    }

    void removeTopic(Topic topic) {
        topics.remove(topic);
    }
}
