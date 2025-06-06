package crode.AbstractFactory.Factory;

import crode.AbstractFactory.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.AbstractFactory.Notifications.WebInstantNotification;
import crode.AbstractFactory.Notifications.WebScheduledNotification;
import crode.Common.Notification;

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
