package Questions.PubSubSystem;

public class PubSubSystemDemo {
    public static void main(String[] args) {

        // creating publishers
        Publisher publisher1 = new Publisher(1);
        Publisher publisher2 = new Publisher(2);

        // creating topics
        Topic topic1 = new Topic("Topic 1");
        Topic topic2 = new Topic("Topic 2");

        publisher1.addTopic(topic1);
        publisher2.addTopic(topic2);

        // creating subscribers
        Subscriber subscriber1 = new PrintSubscriber(1);
        Subscriber subscriber2 = new PrintSubscriber(2);

        topic1.addSubscriber(subscriber1);
        topic2.addSubscriber(subscriber1);
        topic2.addSubscriber(subscriber2);

        // publishing messages
        publisher1.publish(topic1, new Message("Publishing message to topic 1"));
        publisher2.publish(topic2, new Message("Publishing message to topic 2"));


        topic2.removeSubscriber(subscriber1);

        publisher1.publish(topic1, new Message("Again!!! Publishing message to topic 1"));
        publisher2.publish(topic2, new Message("Again!!! Publishing message to topic 2"));
    }
}
