package crode.Adapter;

import crode.Processor.PaymentProcessor;
import crode.Service.StripeService;

// Adapter for Stripe
public class StripeAdapter implements PaymentProcessor {

    private StripeService stripeService;
    private String lastTransactionId;

    public StripeAdapter(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public boolean processPayment(double amount, String currency) {
        // Stripe works in cents
        int amountInCents = (int) (amount * 100);

        StripeService.StripeResponse response =
                stripeService.charge(amountInCents, currency);

        if (response.isSuccessful()) {
            lastTransactionId = response.getChargeId();
            return true;
        }

        return false;
    }

    @Override
    public String getTransactionId() {
        return lastTransactionId;
    }
}
