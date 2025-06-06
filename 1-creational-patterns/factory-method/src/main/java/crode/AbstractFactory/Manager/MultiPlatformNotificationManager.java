package crode.AbstractFactory.Manager;

import crode.AbstractFactory.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.Common.Notification;

public class MultiPlatformNotificationManager {

    private NotificationAbstractFactory factory;

    public MultiPlatformNotificationManager(NotificationAbstractFactory factory) {
        this.factory = factory;
    }

    public void sendInstantNotification(String message, String recipient) {
        System.out.println("INSTANT NOTIFICATION REQUEST");
        System.out.println("Platform: " + factory.getPlatformName());

        Notification notification = factory.createInstantNotification();
        notification.send(message, recipient);
    }

    public void scheduleNotification(String message, String recipient) {
        System.out.println("SCHEDULED NOTIFICATION REQUEST");
        System.out.println("Platform: " + factory.getPlatformName());

        Notification notification = factory.createScheduledNotification();
        notification.send(message, recipient);
    }

    public void sendBothTypes(String message, String recipient) {
        System.out.println("SENDING BOTH INSTANT AND SCHEDULED");
        System.out.println("Platform: " + factory.getPlatformName());

        sendInstantNotification(message, recipient);
        scheduleNotification("Reminder: " + message, recipient);
        System.out.println();
    }
}
