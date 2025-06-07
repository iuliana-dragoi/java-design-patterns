package crode.Processor;

// Target interface that client wants
public interface PaymentProcessor {
    boolean processPayment(double amount, String currency);
    String getTransactionId();
}
