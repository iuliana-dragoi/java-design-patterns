package crode;

public interface Notification {

    void send(String message, String recipient);
    NotificationType getType();
}
