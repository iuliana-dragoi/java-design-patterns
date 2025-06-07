package crode;

import crode.AbstractFactory.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.AbstractFactory.Manager.MultiPlatformNotificationManager;
import crode.AbstractFactory.Provider.NotificationFactoryProvider;
import crode.Common.Notification;
import crode.Common.NotificationType;
import crode.FactoryMethod.Service.AbstractService.NotificationService;
import crode.FactoryMethod.Service.MarketingService;
import crode.FactoryMethod.Service.MonitoringService;
import crode.FactoryMethod.Service.SecurityService;
import crode.FactoryMethod.Service.SocialService;
import crode.SimpleFactory.Factory.NotificationFactory;


public class NotificationFactoryDemo {

    public static void main(String[] args) {

        // SIMPLE FACTORY
        System.out.println("\nSIMPLE FACTORY PATTERN");

        try {
            Notification email = NotificationFactory.createNotification(NotificationType.EMAIL);
            Notification sms = NotificationFactory.createNotification(NotificationType.SMS);

            email.send("Welcome to our service!", "user@example.com");
            sms.send("Your verification code: 123456", "+40123456789");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // FACTORY METHOD PATTERN
        System.out.println("\n FACTORY METHOD PATTERN");

        NotificationService marketing = new MarketingService();
        NotificationService security = new SecurityService();
        NotificationService social = new SocialService();
        NotificationService monitoring = new MonitoringService();

        marketing.processNotification("New product launch!", "customers@list.com", "NORMAL");
        security.processNotification("Suspicious login detected!", "+40123456789", "HIGH");
        social.processNotification("John liked your post", "user123", "NORMAL");
        monitoring.processNotification("Server CPU > 90%", "devops-team", "HIGH");

        //  ABSTRACT FACTORY PATTERN DEMO
        System.out.println("\n ABSTRACT FACTORY PATTERN");

        String[] platforms = {"MOBILE", "WEB", "ENTERPRISE"};
        for (String platform : platforms) {
            try {
                NotificationAbstractFactory factory = NotificationFactoryProvider.getFactory(platform);
                MultiPlatformNotificationManager manager = new MultiPlatformNotificationManager(factory);

                manager.sendBothTypes("Meeting in 30 minutes", "team@company.com");

            } catch (Exception e) {
                System.err.println("Error for " + platform + ": " + e.getMessage());
            }
        }
    }
}
