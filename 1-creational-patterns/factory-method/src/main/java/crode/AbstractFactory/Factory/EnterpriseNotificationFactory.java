package crode.AbstractFactory.Factory;

import crode.AbstractFactory.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.AbstractFactory.Notifications.EnterpriseInstantNotification;
import crode.AbstractFactory.Notifications.EnterpriseScheduledNotification;
import crode.Common.Notification;

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
