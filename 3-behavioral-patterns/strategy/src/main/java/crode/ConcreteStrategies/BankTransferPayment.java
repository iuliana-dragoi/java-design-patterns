package crode.ConcreteStrategies;

import crode.StrategyInterface.PaymentStrategy;

public class BankTransferPayment implements PaymentStrategy {

    private String bankAccount;
    private String routingNumber;

    public BankTransferPayment(String bankAccount, String routingNumber) {
        this.bankAccount = bankAccount;
        this.routingNumber = routingNumber;
    }

    @Override
    public void pay(double amount) {
        if(validate()) {
            System.out.println("Bank transfer of " + amount + " RON into account " + bankAccount.substring(0, 4) + "****");
        }
    }

    @Override
    public boolean validate() {
        if (bankAccount.length() >= 10 && routingNumber.length() == 4) {
            System.out.println("Valid bank account");
            return true;
        }
        System.out.println("Invalid bank data!");
        return false;
    }
}
