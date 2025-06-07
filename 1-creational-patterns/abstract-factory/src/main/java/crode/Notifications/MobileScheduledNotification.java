package crode.Notifications;

import crode.Notification;
import crode.NotificationType;

public class MobileScheduledNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("MOBILE SCHEDULED: Push notification scheduled");
        System.out.println("To: " + recipient + " | Message: " + message);
        System.out.println("Features: Local scheduling, repeat options");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.MOBILE_SCHEDULED;
    }
}
