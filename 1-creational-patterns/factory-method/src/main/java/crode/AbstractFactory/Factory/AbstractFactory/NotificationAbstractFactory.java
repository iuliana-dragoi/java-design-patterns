package crode.AbstractFactory.Factory.AbstractFactory;

import crode.Common.Notification;

public interface NotificationAbstractFactory {
    Notification createInstantNotification();
    Notification createScheduledNotification();
    String getPlatformName();
}
