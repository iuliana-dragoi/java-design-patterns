package crode.Implementations.Email;

import crode.Interfaces.EmailService;
import crode.Interfaces.Logger;

public class MockEmailService implements EmailService {

    private Logger logger;

    public MockEmailService(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        logger.log("Mock email sent to: " + to);
        // Simulation of sending email
    }
}
