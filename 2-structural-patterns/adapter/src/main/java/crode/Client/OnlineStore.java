package crode.Client;

import crode.Processor.PaymentProcessor;

public class OnlineStore {

    private PaymentProcessor paymentProcessor;

    public void setPaymentProcessor(PaymentProcessor processor) {
        this.paymentProcessor = processor;
    }

    public void checkout(double amount, String currency) {
        System.out.println("\n--- Processing Checkout ---");
        System.out.println("Amount: " + amount + " " + currency);

        if (paymentProcessor == null) {
            System.out.println("No payment processor configured!");
            return;
        }

        boolean success = paymentProcessor.processPayment(amount, currency);

        if (success) {
            String transactionId = paymentProcessor.getTransactionId();
            System.out.println("Payment successful! Transaction ID: " + transactionId);
            System.out.println("Order confirmed and will be shipped soon.");
        } else {
            System.out.println("Payment failed! Please try again.");
        }
    }
}
