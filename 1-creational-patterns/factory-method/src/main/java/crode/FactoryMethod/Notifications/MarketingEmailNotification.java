package crode.FactoryMethod.Notifications;

import crode.Common.Notification;
import crode.Common.NotificationType;

public class MarketingEmailNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("MARKETING EMAIL: Beautiful template sent to " + recipient);
        System.out.println("Content: " + message);
        System.out.println("Includes: Unsubscribe link, tracking pixels");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.MARKETING_EMAIL;
    }
}
