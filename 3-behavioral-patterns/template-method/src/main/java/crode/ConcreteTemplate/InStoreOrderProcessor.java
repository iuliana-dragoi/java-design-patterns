package crode.ConcreteTemplate;

import crode.AbstractTemplateClass.OrderProcessor;

public class InStoreOrderProcessor extends OrderProcessor {

    private String customerName;
    private boolean isLoyaltyMember;

    public InStoreOrderProcessor(String customerName, boolean isLoyaltyMember) {
        this.customerName = customerName;
        this.isLoyaltyMember = isLoyaltyMember;
    }

    @Override
    protected void validateOrder() {
        System.out.println("Validate order in store for " + customerName);
        System.out.println(" - Check product availability");
        if (isLoyaltyMember) {
            System.out.println(" - Apply loyalty member discount");
        }
    }

    @Override
    protected void calculatePricing() {
        System.out.println("Calculate price at the cash register");
        if (isLoyaltyMember) {
            System.out.println(" - Apply 10% discount for loyalty member");
        }
    }

    @Override
    protected void processPayment() {
        System.out.println("Process payment at the cash register");
        System.out.println(" - Accept cash/card");
        System.out.println(" - Issue tax receipt");
    }

    @Override
    protected void sendConfirmation() {
        System.out.println("Handover receipt and product to customer " + customerName);
    }

    // Override hook methods for in-store orders
    @Override
    protected boolean requiresShipping() {
        return false; // No shipping required
    }
}
