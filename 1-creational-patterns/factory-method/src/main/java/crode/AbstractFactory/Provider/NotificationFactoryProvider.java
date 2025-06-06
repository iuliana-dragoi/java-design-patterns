package crode.AbstractFactory.Provider;

import crode.AbstractFactory.Factory.AbstractFactory.NotificationAbstractFactory;
import crode.AbstractFactory.Factory.EnterpriseNotificationFactory;
import crode.AbstractFactory.Factory.MobileNotificationFactory;
import crode.AbstractFactory.Factory.WebNotificationFactory;

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

