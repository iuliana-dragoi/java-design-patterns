package crode.ConcreteStrategies;

import crode.StrategyInterface.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cardHolder;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolder, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        if(validate()) {
            System.out.println("Pay of " + amount + " RON processed by Card **** " + cardNumber.substring(12));
        }
    }

    @Override
    public boolean validate() {
        if(cardNumber.length() == 16 && cvv.length() == 3) {
            System.out.println("Valid card for " + cardHolder);
            return true;
        }
        System.out.println("Invalid card!");
        return false;
    }
}
