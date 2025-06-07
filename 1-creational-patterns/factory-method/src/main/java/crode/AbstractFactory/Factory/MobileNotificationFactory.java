package crode.AbstractFactory.Factory;

import crode.AbstractFactory.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.AbstractFactory.Notifications.MobileInstantNotification;
import crode.AbstractFactory.Notifications.MobileScheduledNotification;
import crode.Common.Notification;

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
