package crode.FactoryMethod.Notifications;

import crode.Common.Notification;
import crode.Common.NotificationType;

public class SocialPushNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("SOCIAL PUSH: Interactive notification to " + recipient);
        System.out.println("Content: " + message);
        System.out.println("Features: Like/Reply buttons, user avatar");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SOCIAL_PUSH;
    }
}
