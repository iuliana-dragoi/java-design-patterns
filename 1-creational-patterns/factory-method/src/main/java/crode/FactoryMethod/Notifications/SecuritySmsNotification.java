package crode.FactoryMethod.Notifications;

import crode.Common.Notification;
import crode.Common.NotificationType;

public class SecuritySmsNotification implements Notification {

    @Override
    public void send(String message, String recipient) {
        System.out.println("🔐 SECURITY SMS: High-priority to " + recipient);
        System.out.println("   Content: " + message);
        System.out.println("   Features: Encryption, delivery confirmation");
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SECURITY_SMS;
    }
}
