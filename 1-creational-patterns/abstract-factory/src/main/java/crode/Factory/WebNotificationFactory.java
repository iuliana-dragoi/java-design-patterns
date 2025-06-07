package crode.Factory;

import crode.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.Notification;
import crode.Notifications.WebInstantNotification;
import crode.Notifications.WebScheduledNotification;

public class WebNotificationFactory implements NotificationAbstractFactory {

    @Override
    public Notification createInstantNotification() {
        System.out.println("WEB ABSTRACT FACTORY: Creating instant notification");
        return new WebInstantNotification();
    }

    @Override
    public Notification createScheduledNotification() {
        System.out.println("🏭 WEB ABSTRACT FACTORY: Creating scheduled notification");
        return new WebScheduledNotification();
    }

    @Override
    public String getPlatformName() {
        return "Web Platform";
    }
}
