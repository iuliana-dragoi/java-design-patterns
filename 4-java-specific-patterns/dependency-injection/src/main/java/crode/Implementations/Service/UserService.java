package crode.Implementations.Service;

import crode.Interfaces.Logger;

public class UserService {

    private NotificationService notificationService;
    private Logger logger;

    public UserService(NotificationService notificationService, Logger logger) {
        this.notificationService = notificationService;
        this.logger = logger;
    }

    public void registerUser(String username, String email) {
        logger.log("Registering new user: " + username);
        System.out.println("User saved to database: " + username);
        notificationService.sendWelcomeNotification(email, username);
        logger.log("User registration completed for: " + username);
    }

    public void requestPasswordReset(String email) {
        logger.log("Password reset requested for: " + email);
        notificationService.sendPasswordResetNotification(email);
    }
}
