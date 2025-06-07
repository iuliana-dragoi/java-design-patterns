package crode.FactoryMethod.Service;

import crode.Common.Notification;
import crode.FactoryMethod.Notifications.SecuritySmsNotification;
import crode.FactoryMethod.Service.AbstractService.NotificationService;

public class SecurityService extends NotificationService {

    @Override
    protected Notification createNotification() {
        System.out.println("SECURITY FACTORY METHOD: Creating security notification");
        return new SecuritySmsNotification();
    }

    @Override
    protected String getServiceName() {
        return "Security Alert Service";
    }
}
