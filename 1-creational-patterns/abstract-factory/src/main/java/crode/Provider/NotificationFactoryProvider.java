package crode.Provider;

import crode.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.Factory.EnterpriseNotificationFactory;
import crode.Factory.MobileNotificationFactory;
import crode.Factory.WebNotificationFactory;

public class NotificationFactoryProvider {

    public static NotificationAbstractFactory getFactory(String platform) {

        switch (platform.toUpperCase()) {
            case "MOBILE":
                return new MobileNotificationFactory();
            case "WEB":
                return new WebNotificationFactory();
            case "ENTERPRISE":
                return new EnterpriseNotificationFactory();
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }
}

