package crode.Notifications;

import crode.Notification;
import crode.NotificationType;

public class WebInstantNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("WEB INSTANT: Browser notification sent immediately");
        System.out.println("To: " + recipient + " | Message: " + message);
        System.out.println("Features: Desktop notification, auto-close timer");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.WEB_INSTANT;
    }
}
