package crode.Factory;

import crode.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.Notification;
import crode.Notifications.EnterpriseInstantNotification;
import crode.Notifications.EnterpriseScheduledNotification;

public class EnterpriseNotificationFactory implements NotificationAbstractFactory {

    @Override
    public Notification createInstantNotification() {
        System.out.println("ENTERPRISE ABSTRACT FACTORY: Creating instant notification");
        return new EnterpriseInstantNotification();
    }

    @Override
    public Notification createScheduledNotification() {
        System.out.println("ENTERPRISE ABSTRACT FACTORY: Creating scheduled notification");
        return new EnterpriseScheduledNotification();
    }

    @Override
    public String getPlatformName() {
        return "Enterprise Platform";
    }
}
