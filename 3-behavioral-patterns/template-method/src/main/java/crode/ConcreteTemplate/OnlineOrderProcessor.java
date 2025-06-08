package crode.ConcreteTemplate;

import crode.AbstractTemplateClass.OrderProcessor;

public class OnlineOrderProcessor extends OrderProcessor {

    private String customerEmail;
    private double orderValue;

    public OnlineOrderProcessor(String customerEmail, double orderValue) {
        this.customerEmail = customerEmail;
        this.orderValue = orderValue;
    }

    @Override
    protected void validateOrder() {
        System.out.println("Validate online order for " + customerEmail);
        System.out.println(" - Verify customer data");
        System.out.println(" - Validate shipping address");
    }

    @Override
    protected void calculatePricing() {
        double shipping = orderValue > 100 ? 0 : 15.0;
        double total = orderValue + shipping;
        System.out.println("Calculate price: " + orderValue + " + shipping " + shipping + " = " + total + " RON");
    }

    @Override
    protected void processPayment() {
        System.out.println("Process online card payment");
        System.out.println(" - Connect to payment gateway");
        System.out.println(" - Authorize transaction");
    }

    @Override
    protected void sendConfirmation() {
        System.out.println("Sending confirmation email: " + customerEmail);
        System.out.println(" - Email with order details");
        System.out.println(" - Tracking link");
    }
}
