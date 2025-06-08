package crode.Implementations.Email;

import crode.Interfaces.EmailService;
import crode.Interfaces.Logger;

public class SMTPEmailService implements EmailService {

    private String smtpServer;
    private Logger logger;

    // Constructor Injection
    public SMTPEmailService(String smtpServer, Logger logger) {
        this.smtpServer = smtpServer;
        this.logger = logger;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        logger.log("Sending email via " + smtpServer);
        System.out.println("Email sent to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }

}
