package crode.AbstractTemplateClass;

public abstract class OrderProcessor {

    // Template Method - Define general algorithm
    public final void processOrder() {
        System.out.println("=== Start Order Processing ===");

        validateOrder();
        calculatePricing();

        if (requiresInventoryCheck()) {
            checkInventory();
        }

        processPayment();

        if (requiresShipping()) {
            arrangeShipping();
        }

        sendConfirmation();
        completeOrder();

        System.out.println(" === Order Completed ===\n");
    }

    // Abstract methods - must be implemented by subclasses
    protected abstract void validateOrder();
    protected abstract void calculatePricing();
    protected abstract void processPayment();
    protected abstract void sendConfirmation();

    // Concrete methods with default implementation
    protected void checkInventory() {
        System.out.println("Checking inventory...");
    }

    protected void arrangeShipping() {
        System.out.println("Organizing shipping...");
    }

    protected void completeOrder() {
        System.out.println("Order closed in system");
    }

    // Hook methods - can be optionally overridden
    protected boolean requiresInventoryCheck() {
        return true; // Default: checking inventory
    }

    protected boolean requiresShipping() {
        return true; // Default: requiring shipping
    }
}
