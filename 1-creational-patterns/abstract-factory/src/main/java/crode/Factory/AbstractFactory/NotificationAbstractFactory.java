package crode.Factory.AbstractFactory;

import crode.Notification;

public interface NotificationAbstractFactory {
    Notification createInstantNotification();
    Notification createScheduledNotification();
    String getPlatformName();
}
