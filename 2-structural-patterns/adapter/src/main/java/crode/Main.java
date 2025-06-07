package crode;

import crode.Client.OnlineStore;
import crode.Factory.PaymentProcessorFactory;
import crode.Processor.PaymentProcessor;
import crode.Service.PayPalService;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Adapter Pattern Demo ===");

        OnlineStore store = new OnlineStore();

        // Test cu PayPal
        System.out.println("\nUsing PayPal Processor:");
        store.setPaymentProcessor(PaymentProcessorFactory.createProcessor("paypal"));
        store.checkout(29.99, "USD");
        store.checkout(25.50, "EUR");

        // Test cu Stripe
        System.out.println("\nUsing Stripe Processor:");
        store.setPaymentProcessor(PaymentProcessorFactory.createProcessor("stripe"));
        store.checkout(15.75, "USD");
        store.checkout(120.00, "RON");

        // Proof of flexibility - changes the processor during runtime
        System.out.println("\nSwitching Payment Processors:");

        PaymentProcessor paypal = PaymentProcessorFactory.createProcessor("paypal");
        PaymentProcessor stripe = PaymentProcessorFactory.createProcessor("stripe");

        store.setPaymentProcessor(paypal);
        store.checkout(50.0, "USD");

        store.setPaymentProcessor(stripe);
        store.checkout(50.0, "USD");

        // Direct test with the services (without adapter) - differences
        System.out.println("\nDirect Service Usage (without adapter):");
        PayPalService directPayPal = new PayPalService();
        directPayPal.makePayment(19.99);
        System.out.println("Direct PayPal transaction: " + directPayPal.getPayPalTransactionId());
    }
}
