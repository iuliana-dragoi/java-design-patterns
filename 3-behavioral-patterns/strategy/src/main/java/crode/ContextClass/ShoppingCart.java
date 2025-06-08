package crode.ContextClass;

import crode.ConcreteStrategies.PayPalPayment;
import crode.StrategyInterface.PaymentStrategy;

public class ShoppingCart {

    private PaymentStrategy paymentStrategy;
    private double totalAmount = 0;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void addItem(String item, double price) {
        totalAmount += price;
        System.out.println("Added: " + item + " - " + price + " RON");
    }

    public void checkOut() {
        if(paymentStrategy == null) {
            System.out.println("Select a payment method!");
            return;
        }

        System.out.println("Total amount: " + totalAmount + " RON");
        System.out.println("Payment processing...");
        paymentStrategy.pay(totalAmount);

        if(paymentStrategy.validate()) {
            totalAmount = 0;
            System.out.println("Payment finished successfully!");
        }
    }

    public double getTotal() {
        return totalAmount;
    }
}
