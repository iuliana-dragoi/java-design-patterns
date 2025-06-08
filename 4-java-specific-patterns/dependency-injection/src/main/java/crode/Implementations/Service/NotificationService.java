package crode.Implementations.Service;

import crode.Interfaces.ConfigurationService;
import crode.Interfaces.EmailService;
import crode.Interfaces.Logger;

public class NotificationService {

    private EmailService emailService;
    private Logger logger;
    private ConfigurationService configService;

    // Constructor Injection - recommended
    public NotificationService(EmailService emailService, Logger logger, ConfigurationService configService) {
        this.emailService = emailService;
        this.logger = logger;
        this.configService = configService;
    }

    // Setter Injection - alternative
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendWelcomeNotification(String userEmail, String username) {
        logger.log("Preparing welcome notification for: " + username);

        String appName = configService.getProperty("app.name");
        String subject = "Welcome to " + appName + "!";
        String body = "Hello " + username + ",\n\nWelcome to our platform!\n\nBest regards,\n" + appName + " Team";

        emailService.sendEmail(userEmail, subject, body);
        logger.log("Welcome notification sent successfully");
    }

    public void sendPasswordResetNotification(String userEmail) {
        logger.log("Sending password reset notification");

        String subject = "Password Reset Request";
        String body = "Click here to reset your password: http://example.com/reset";

        emailService.sendEmail(userEmail, subject, body);
    }
}
