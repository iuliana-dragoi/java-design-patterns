package crode.SimpleFactory.Factory;

import crode.Common.NotificationType;
import crode.SimpleFactory.Notifications.EmailNotification;
import crode.SimpleFactory.Notifications.PushNotification;
import crode.SimpleFactory.Notifications.SlackNotification;
import crode.SimpleFactory.Notifications.SmsNotification;
import crode.Common.Notification;
import crode.SimpleFactory.Wrapper.PriorityNotificationWrapper;

public class NotificationFactory {

    public static Notification createNotification(NotificationType type) {

        if(type == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }

        switch(type) {
            case EMAIL: return new EmailNotification();
            case SMS: return new SmsNotification();
            case PUSH: return new PushNotification();
            case SLACK: return new SlackNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: "+ type);
        }
    }

    public static NotificationType[] getSupportedTypes() {
        return NotificationType.values();
    }

    public static Notification createNotificationWithPriority(NotificationType type, String priority) {
        Notification notification = createNotification(type);
        return new PriorityNotificationWrapper(notification, priority);
    }
}
