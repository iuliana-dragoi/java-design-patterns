package crode.FactoryMethod.Service;

import crode.Common.Notification;
import crode.FactoryMethod.Notifications.SocialPushNotification;
import crode.FactoryMethod.Service.AbstractService.NotificationService;

public class SocialService extends NotificationService {

    @Override
    protected Notification createNotification() {
        System.out.println("SOCIAL FACTORY METHOD: Creating social notification");
        return new SocialPushNotification();
    }

    @Override
    protected String getServiceName() {
        return "Social Media Service";
    }
}
