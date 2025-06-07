package crode.FactoryMethod.Service;

import crode.Common.Notification;
import crode.FactoryMethod.Notifications.SystemAlertNotification;
import crode.FactoryMethod.Service.AbstractService.NotificationService;

public class MonitoringService extends NotificationService {

    @Override
    protected Notification createNotification() {
        System.out.println("MONITORING FACTORY METHOD: Creating system alert");
        return new SystemAlertNotification();
    }

    @Override
    protected String getServiceName() {
        return "System Monitoring Service";
    }
}
