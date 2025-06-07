package crode.FactoryMethod.Service;

import crode.Common.Notification;
import crode.FactoryMethod.Notifications.MarketingEmailNotification;
import crode.FactoryMethod.Service.AbstractService.NotificationService;

public class MarketingService extends NotificationService {

    @Override
    protected Notification createNotification() {
        System.out.println("MARKETING FACTORY METHOD: Creating marketing notification");
        return new MarketingEmailNotification();
    }

    @Override
    protected String getServiceName() {
        return "Marketing Campaign Service";
    }
}
