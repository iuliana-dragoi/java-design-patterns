package crode.SimpleFactory;

import crode.SimpleFactory.Factory.NotificationFactory;
import crode.Common.NotificationType;
import crode.SimpleFactory.Notifications.EmailNotification;
import crode.Common.Notification;
import crode.SimpleFactory.Service.NotificationService;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== FACTORY PATTERN DEMONSTRATION ===\n");

        NotificationService service = new NotificationService();

        // Test 1: Create different types of notifications
        System.out.println("Test with different types:");
        service.showSupportedTypes();

        service.sendNotification(NotificationType.EMAIL, "Welcome to our platform!", "user@example.com");
        service.sendNotification(NotificationType.SMS, "Your code is: 123456", "+40123456789");
        service.sendNotification(NotificationType.PUSH, "New message received", "device_id_12345");
        service.sendNotification(NotificationType.SLACK, "Deployment completed successfully", "#dev-team");

        System.out.println("\n");

        // Test 2: Bulk notifications
        System.out.println("Test Bulk notifications:");
        NotificationType[] types = {NotificationType.EMAIL, NotificationType.SMS, NotificationType.SLACK, NotificationType.PUSH};
        service.sendBulkNotifications(types, "System maintenance scheduled", "admin@company.com");

        System.out.println("\n");

        // Test 3: Factory with priorities (extension)
        System.out.println("Test Factory with priorities:");
        try {
            Notification priorityEmail = NotificationFactory.createNotificationWithPriority(NotificationType.EMAIL, "HIGH");
            priorityEmail.send("URGENT: Server down!", "admin@company.com");

            Notification normalSMS = NotificationFactory.createNotificationWithPriority(NotificationType.SMS, "LOW");
            normalSMS.send("Reminder: Meeting at 3 PM", "+40123456789");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\n");

        // Test 4: Direct creation VS Factory
        System.out.println("Comparation: Direct Creation vs Factory:");

        // Direct creation (less flexible)
        System.out.println(" Direct creation:");
        EmailNotification email = new EmailNotification();
        email.send("Direct creation", "user@example.com");

        // Using Factory (more flexible)
        System.out.println("Using Factory:");
        NotificationType userChoice = NotificationType.EMAIL; // Can come from user input, config, etc.
        Notification notification = NotificationFactory.createNotification(userChoice);
        notification.send("Factory creation", "user@example.com");
    }
}
