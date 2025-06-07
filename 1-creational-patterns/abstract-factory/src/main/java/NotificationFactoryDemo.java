import crode.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.Manager.MultiPlatformNotificationManager;
import crode.Provider.NotificationFactoryProvider;

public class NotificationFactoryDemo {

    public static void main(String[] args) {

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
