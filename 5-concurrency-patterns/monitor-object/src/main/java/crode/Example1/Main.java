package crode.Example1;

import crode.Example1.MonitorObject.BankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("ACC123", 500);
        BankAccount acc2 = new BankAccount("ACC456", 300);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(() -> acc1.withdraw(200, "Rent payment"));
        executor.execute(() -> acc2.deposit(150, "Paycheck"));
        executor.execute(() -> acc1.transfer(acc2, 100, "Gift"));
        executor.execute(() -> acc2.transfer(acc1, 50, "Refund"));

        executor.shutdown();
    }
}
