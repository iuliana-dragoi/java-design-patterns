package crode.SimpleFactory.Notifications;

import crode.Common.NotificationType;
import crode.Common.Notification;

public class SlackNotification implements Notification {


    @Override
    public void send(String message, String recipient) {
        System.out.println("SLACK NOTIFICATION");
        System.out.println("Channel: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Status: Slack message sent successfully!\n");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SLACK;
    }
}
