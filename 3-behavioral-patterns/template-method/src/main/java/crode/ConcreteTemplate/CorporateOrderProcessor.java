package crode.ConcreteTemplate;

import crode.AbstractTemplateClass.OrderProcessor;

public class CorporateOrderProcessor extends OrderProcessor {

    private String companyName;
    private double orderValue;
    private boolean requiresInvoice;

    public CorporateOrderProcessor(String companyName, double orderValue, boolean requiresInvoice) {
        this.companyName = companyName;
        this.orderValue = orderValue;
        this.requiresInvoice = requiresInvoice;
    }

    @Override
    protected void validateOrder() {
        System.out.println("Corporate order validation for " + companyName);
        System.out.println(" - Check credit limit");
        System.out.println(" - Validate tax data");
    }

    @Override
    protected void calculatePricing() {
        double discount = orderValue > 1000 ? 0.15 : 0.05; // 15% or 5% discount
        double finalPrice = orderValue * (1 - discount);
        System.out.println("Corporate price calculation: " + orderValue + " with discount " + (discount * 100) + "% = " + finalPrice + " RON");
    }

    @Override
    protected void processPayment() {
        System.out.println("Corporate payment processing");
        if (requiresInvoice) {
            System.out.println(" - Generate invoice");
            System.out.println(" - Payment in 30 days");
        } else {
            System.out.println(" - Immediate payment by transfer");
        }
    }

    @Override
    protected void sendConfirmation() {
        System.out.println("Send corporate confirmation to " + companyName);
        if (requiresInvoice) {
            System.out.println(" - Send invoice by email");
        }
        System.out.println(" - Notify purchasing department");
    }

    @Override
    protected boolean requiresInventoryCheck() {
        return orderValue > 500; // Check inventory only for large orders
    }
}
