package crode.Service;

// External service Stripe (Adaptee)
public class StripeService {

    public StripeResponse charge(int amountInCents, String curr) {
        System.out.println("Charging " + amountInCents + " cents in " + curr + " via Stripe");
        return new StripeResponse(
                "stripe_" + System.nanoTime(),
                Math.random() > 0.05 // 95% success rate
        );
    }

    public static class StripeResponse {
        private String chargeId;
        private boolean success;

        public StripeResponse(String chargeId, boolean success) {
            this.chargeId = chargeId;
            this.success = success;
        }

        public String getChargeId() { return chargeId; }
        public boolean isSuccessful() { return success; }
    }
}
