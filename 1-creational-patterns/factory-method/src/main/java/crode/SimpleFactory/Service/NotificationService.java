package crode.SimpleFactory.Service;

import crode.SimpleFactory.Factory.NotificationFactory;
import crode.Common.NotificationType;
import crode.Common.Notification;

public class NotificationService {

    public void sendNotification(NotificationType type, String message, String recipient) {
        try {
            Notification notification = NotificationFactory.createNotification(type);
            notification.send(message, recipient);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void sendBulkNotifications(NotificationType[] types, String message, String recipient) {
        System.out.println("SENDING BULK NOTIFICATIONS");
        for(NotificationType type : types) {
            sendNotification(type, message, recipient);
        }
    }

    public void showSupportedTypes() {
        System.out.println("SUPPORTED NOTIFICATION TYPES:");
        NotificationType[] types = NotificationFactory.getSupportedTypes();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i]);
        }
        System.out.println();
    }
}
