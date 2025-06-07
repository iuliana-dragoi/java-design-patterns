package crode.FactoryMethod.Service.AbstractService;

import crode.Common.Notification;

// Abstract service - defines Factory Method
public abstract class NotificationService {

    public final void processNotification(String message, String recipient, String priority) {
        System.out.println("\nPROCESSING NOTIFICATION REQUEST");
        System.out.println("Service: " + getServiceName());
        System.out.println("Priority: " + priority);

        // Pre-processing comun
        if (priority.equals("HIGH")) {
            System.out.println("HIGH PRIORITY: Adding urgency markers");
        }

        // Factory Method Call - subclasses decide what notification to create
        Notification notification = createNotification();

        // The Sending
        notification.send(message, recipient);

        // Post-processing common
        logNotification(notification, recipient);
        System.out.println("Notification processed successfully!\n");
    }

    protected abstract Notification createNotification();

    protected abstract String getServiceName();

    private void logNotification(Notification notification, String recipient) {
        System.out.println("Logged: " + notification.getType() + " sent to " + recipient);
    }
}
