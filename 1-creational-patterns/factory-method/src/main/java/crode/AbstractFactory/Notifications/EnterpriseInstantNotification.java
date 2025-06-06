package crode.AbstractFactory.Notifications;

import crode.Common.Notification;
import crode.Common.NotificationType;

public class EnterpriseInstantNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("🏢 ENTERPRISE INSTANT: Slack/Teams message sent");
        System.out.println("   To: " + recipient + " | Message: " + message);
        System.out.println("   Features: @mention, channel broadcast, thread reply");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.ENTERPRISE_INSTANT;
    }
}
