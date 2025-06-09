package crode.Example1.MessageModel;

public class Message {

    private final int id;
    private final String content;
    private final long timestamp;
    private final String priority;

    public Message(int id, String content, String priority) {
        this.id = id;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return String.format("Message{id=%d, priority='%s', content='%s', timestamp=%d}", id, priority, content, timestamp);
    }
}
