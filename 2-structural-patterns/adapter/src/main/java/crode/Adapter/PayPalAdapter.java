package crode.Adapter;

import crode.Processor.PaymentProcessor;
import crode.Service.PayPalService;

// Adapter for PayPal
public class PayPalAdapter implements PaymentProcessor {

    private PayPalService payPalService;
    private String lastTransactionId;

    public PayPalAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public boolean processPayment(double amount, String currency) {
        // Convert to USD if is necessary
        double usdAmount = convertToUSD(amount, currency);

        payPalService.makePayment(usdAmount);

        boolean success = payPalService.isPaymentSuccessful();
        if (success) {
            lastTransactionId = payPalService.getPayPalTransactionId();
        }

        return success;
    }

    @Override
    public String getTransactionId() {
        return lastTransactionId;
    }

    private double convertToUSD(double amount, String currency) {
        if ("EUR".equals(currency)) {
            return amount * 1.1; // Simplified conversion
        } else if ("RON".equals(currency)) {
            return amount * 0.22; // Simplified conversion
        }
        return amount; // Assume USD
    }
}
