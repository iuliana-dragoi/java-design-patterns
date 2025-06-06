package crode.AbstractFactory.Notifications;

import crode.Common.Notification;
import crode.Common.NotificationType;

public class EnterpriseScheduledNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("ENTERPRISE SCHEDULED: Workflow notification scheduled");
        System.out.println("To: " + recipient + " | Message: " + message);
        System.out.println("Features: Approval chain, SLA tracking");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.ENTERPRISE_SCHEDULED;
    }
}
