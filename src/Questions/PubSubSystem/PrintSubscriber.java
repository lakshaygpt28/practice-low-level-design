package Questions.PubSubSystem;

public class PrintSubscriber implements Subscriber {
    private final int id;

    public PrintSubscriber(int id) {
        this.id = id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Subscriber: " + id + " received message content: " + message.getContent());
    }
}
