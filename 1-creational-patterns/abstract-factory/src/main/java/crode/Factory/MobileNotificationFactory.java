package crode.Factory;

import crode.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.Notification;
import crode.Notifications.MobileInstantNotification;
import crode.Notifications.MobileScheduledNotification;

public class MobileNotificationFactory implements NotificationAbstractFactory {

    @Override
    public Notification createInstantNotification() {
        System.out.println("MOBILE ABSTRACT FACTORY: Creating instant notification");
        return new MobileInstantNotification();
    }

    @Override
    public Notification createScheduledNotification() {
        System.out.println("MOBILE ABSTRACT FACTORY: Creating scheduled notification");
        return new MobileScheduledNotification();
    }

    @Override
    public String getPlatformName() {
        return "Mobile Platform";
    }
}
