package crode.Notifications;

import crode.Notification;
import crode.NotificationType;

public class WebScheduledNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("WEB SCHEDULED: Email scheduled for later delivery");
        System.out.println("To: " + recipient + " | Message: " + message);
        System.out.println("Features: HTML template, attachment support");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.WEB_SCHEDULED;
    }
}
