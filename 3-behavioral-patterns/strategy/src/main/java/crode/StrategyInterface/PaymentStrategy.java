package crode.StrategyInterface;

public interface PaymentStrategy {
    void pay(double amount);
    boolean validate();
}
