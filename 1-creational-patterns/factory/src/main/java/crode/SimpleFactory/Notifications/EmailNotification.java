package crode.SimpleFactory.Notifications;

import crode.Common.NotificationType;
import crode.Common.Notification;

public class EmailNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("EMAIL NOTIFICATION");
        System.out.println("To: " + recipient);
        System.out.println("Subject: System Notification");
        System.out.println("Message: " + message);
        System.out.println("Status: Email sent successfully!\n");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
