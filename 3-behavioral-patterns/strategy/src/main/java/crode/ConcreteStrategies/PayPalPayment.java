package crode.ConcreteStrategies;

import crode.StrategyInterface.PaymentStrategy;

public class PayPalPayment implements PaymentStrategy {

    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public void pay(double amount) {
        if(validate()) {
            System.out.println("Pay of " + amount + " RON processed by PayPal ("+ email +")");
        }
    }

    @Override
    public boolean validate() {
        if (email.contains("@") && password.length() >= 6) {
            System.out.println("PayPal valid for " + email);
            return true;
        }
        System.out.println("Invalid credentials!");
        return false;
    }
}
