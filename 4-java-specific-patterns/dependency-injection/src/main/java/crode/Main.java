package crode;

import crode.Implementations.Config.PropertiesConfigurationService;
import crode.Implementations.Email.MockEmailService;
import crode.Implementations.Email.SMTPEmailService;
import crode.Implementations.Log.ConsoleLogger;
import crode.Implementations.Log.FileLogger;
import crode.Implementations.Service.NotificationService;
import crode.Implementations.Service.UserService;
import crode.Interfaces.ConfigurationService;
import crode.Interfaces.EmailService;
import crode.Interfaces.Logger;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Dependency Injection Pattern Demo ===");

        // Manual Dependency Injection
        System.out.println("\n1. Manual DI with Console Logger:");
        demonstrateManualDI();

        System.out.println("\n2. Manual DI with File Logger:");
        demonstrateWithFileLogger();

        System.out.println("\n3. Using Simple DI Container:");
        demonstrateWithDIContainer();

        System.out.println("\n4. Testing with Mock Services:");
        demonstrateWithMockServices();
    }

    private static void demonstrateManualDI() {
        // Create dependencies
        Logger logger = new ConsoleLogger();
        ConfigurationService configService = new PropertiesConfigurationService();
        EmailService emailService = new SMTPEmailService("smtp.gmail.com", logger);

        // Inject dependencies
        NotificationService notificationService = new NotificationService(emailService, logger, configService);
        UserService userService = new UserService(notificationService, logger);

        // Use the service
        userService.registerUser("john_doe", "john@example.com");
    }

    private static void demonstrateWithFileLogger() {
        // Change the logger implementation without modifying other classes
        Logger logger = new FileLogger("app.log");
        ConfigurationService configService = new PropertiesConfigurationService();
        EmailService emailService = new SMTPEmailService("smtp.yahoo.com", logger);

        NotificationService notificationService = new NotificationService(emailService, logger, configService);
        UserService userService = new UserService(notificationService, logger);

        userService.registerUser("jane_doe", "jane@example.com");
    }

    private static void demonstrateWithDIContainer() {
        // Create and configure the DI container
        DIContainer container = new DIContainer();

        // Register the services
        container.register(Logger.class, new ConsoleLogger());
        container.register(ConfigurationService.class, new PropertiesConfigurationService());
        container.register(EmailService.class, new SMTPEmailService("smtp.outlook.com", container.resolve(Logger.class)));

        // Resolve dependencies
        NotificationService notificationService = new NotificationService(
            container.resolve(EmailService.class),
            container.resolve(Logger.class),
            container.resolve(ConfigurationService.class)
        );

        UserService userService = new UserService(notificationService, container.resolve(Logger.class));

        userService.registerUser("bob_smith", "bob@example.com");
    }

    private static void demonstrateWithMockServices() {
        // For testing, we use mock services
        Logger logger = new ConsoleLogger();
        ConfigurationService configService = new PropertiesConfigurationService();
        EmailService mockEmailService = new MockEmailService(logger);

        NotificationService notificationService = new NotificationService(mockEmailService, logger, configService);
        UserService userService = new UserService(notificationService, logger);

        userService.registerUser("test_user", "test@example.com");
        userService.requestPasswordReset("test@example.com");
    }
}
