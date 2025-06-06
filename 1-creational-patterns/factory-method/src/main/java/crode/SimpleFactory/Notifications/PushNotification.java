package crode.SimpleFactory.Notifications;

import crode.Common.NotificationType;
import crode.Common.Notification;

public class PushNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("PUSH NOTIFICATION");
        System.out.println("Device: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Status: Push notification sent successfully!\n");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.PUSH;
    }
}
