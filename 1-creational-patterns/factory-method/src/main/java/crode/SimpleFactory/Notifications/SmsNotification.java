package crode.SimpleFactory.Notifications;

import crode.Common.NotificationType;
import crode.Common.Notification;

public class SmsNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("SMS NOTIFICATION");
        System.out.println("To: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Status: SMS sent successfully!\n");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}
