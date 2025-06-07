package crode.Factory;

import crode.Adapter.PayPalAdapter;
import crode.Adapter.StripeAdapter;
import crode.Processor.PaymentProcessor;
import crode.Service.PayPalService;
import crode.Service.StripeService;

public class PaymentProcessorFactory {

    public static PaymentProcessor createProcessor(String type) {
        switch (type.toLowerCase()) {
            case "paypal":
                return new PayPalAdapter(new PayPalService());
            case "stripe":
                return new StripeAdapter(new StripeService());
            default:
                throw new IllegalArgumentException("Unknown payment processor: " + type);
        }
    }
}
