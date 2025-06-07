package crode.FactoryMethod.Notifications;

import crode.Common.Notification;
import crode.Common.NotificationType;

public class SystemAlertNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("SYSTEM ALERT: Critical notification to " + recipient);
        System.out.println("Content: " + message);
        System.out.println("Features: Auto-escalation, on-call integration");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SYSTEM_ALERT;
    }
}
