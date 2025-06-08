package crode;

import crode.ConcreteStrategies.BankTransferPayment;
import crode.ConcreteStrategies.CreditCardPayment;
import crode.ConcreteStrategies.PayPalPayment;
import crode.ContextClass.ShoppingCart;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        System.out.println("\n=== Add Items ===");
        cart.addItem("Laptop", 2500.00);
        cart.addItem("Mouse", 150.00);
        cart.addItem("Keyboard", 300.00);

        System.out.println("\n=== Payment with Credit Card ===");
        CreditCardPayment creditCardPayment = new CreditCardPayment("1234567890123456", "Ion Popescu", "123");
        cart.setPaymentStrategy(creditCardPayment);
        cart.checkOut();

        System.out.println("\n===Add more items ===");
        cart.addItem("Monitor", 800.00);
        cart.addItem("Headphones", 200.00);

        PayPalPayment payPalPayment = new PayPalPayment("ion.popescu@email.com", "pass123");
        cart.setPaymentStrategy(payPalPayment);
        cart.checkOut();

        System.out.println("\n=== Large payment ===");
        cart.addItem("Car", 25000.00);

        System.out.println("\n=== Payment with Bank Transfer ===");
        BankTransferPayment bankTransferPayment = new BankTransferPayment("RO12345678901234567890","RZBR");
        cart.setPaymentStrategy(bankTransferPayment);
        cart.checkOut();
    }
}
