package crode.SimpleFactory.Wrapper;

import crode.Common.NotificationType;
import crode.Common.Notification;

public class PriorityNotificationWrapper implements Notification {

    private Notification notification;
    private String priority;

    public PriorityNotificationWrapper(Notification notification, String priority) {
        this.notification = notification;
        this.priority = priority;
    }

    @Override
    public void send(String message, String recipient) {
        System.out.println("PRIORITY: " + priority.toUpperCase());
        notification.send(message, recipient);
    }

    @Override
    public NotificationType getType() {
        return notification.getType();
    }
}
