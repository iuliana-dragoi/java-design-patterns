package crode.Notifications;

import crode.Notification;
import crode.NotificationType;

public class MobileInstantNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("MOBILE INSTANT: Push notification sent immediately");
        System.out.println("To: " + recipient + " | Message: " + message);
        System.out.println("Features: Sound, vibration, lock screen display");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.MOBILE_INSTANT;
    }
}
