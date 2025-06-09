package crode.Example1.MonitorObject;

import crode.Example1.Transaction;
import crode.Example1.TransactionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {
    private double balance;
    private final String accountNumber;
    private final AtomicLong transactionIdGenerator = new AtomicLong(1);
    private final List<Transaction> transactionHistory = new ArrayList<>();
    private final Object balanceMonitor = new Object();
    private boolean accountFrozen = false;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // SYNCHRONIZED DEPOSIT METHOD
    public synchronized boolean deposit(double amount, String description) {
        if (accountFrozen) {
            System.out.println("DEPOSIT REJECTED: Account " + accountNumber + " is frozen");
            return false;
        }

        if (amount <= 0) {
            System.out.println("DEPOSIT REJECTED: Invalid amount " + amount);
            return false;
        }

        try {
            // Simulate processing time
            Thread.sleep(100 + new Random().nextInt(200));

            double oldBalance = balance;
            balance += amount;

            Transaction transaction = new Transaction(
                    transactionIdGenerator.getAndIncrement(),
                    TransactionType.DEPOSIT,
                    amount,
                    oldBalance,
                    balance,
                    description
            );

            transactionHistory.add(transaction);

            System.out.println(String.format("[%s] DEPOSIT: %s %.2f -> Balance: %.2f (Transaction ID: %d)",
                    Thread.currentThread().getName(), description, amount, balance, transaction.getId()));

            // Notify waiting withdrawal threads
            synchronized (balanceMonitor) {
                balanceMonitor.notifyAll();
            }

            return true;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    // SYNCHRONIZED WITHDRAWAL METHOD WITH WAIT/NOTIFY
    public synchronized boolean withdraw(double amount, String description) {
        if (accountFrozen) {
            System.out.println("WITHDRAWAL REJECTED: Account " + accountNumber + " is frozen");
            return false;
        }

        if (amount <= 0) {
            System.out.println("WITHDRAWAL REJECTED: Invalid amount " + amount);
            return false;
        }

        try {
            // Wait until sufficient balance is available
            synchronized (balanceMonitor) {
                while (balance < amount && !accountFrozen) {
                    System.out.println(String.format("[%s] WAITING: Insufficient balance %.2f for withdrawal %.2f",
                            Thread.currentThread().getName(), balance, amount));
                    balanceMonitor.wait(); // Wait for deposit
                }
            }

            if (accountFrozen) {
                System.out.println("WITHDRAWAL CANCELLED: Account frozen while waiting");
                return false;
            }

            // Simulate processing time
            Thread.sleep(150 + new Random().nextInt(300));

            double oldBalance = balance;
            balance -= amount;

            Transaction transaction = new Transaction(
                    transactionIdGenerator.getAndIncrement(),
                    TransactionType.WITHDRAWAL,
                    amount,
                    oldBalance,
                    balance,
                    description
            );

            transactionHistory.add(transaction);

            System.out.println(String.format("[%s] WITHDRAWAL: %s %.2f -> Balance: %.2f (Transaction ID: %d)",
                    Thread.currentThread().getName(), description, amount, balance, transaction.getId()));

            return true;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    // SYNCHRONIZED TRANSFER METHOD
    public boolean transfer(BankAccount targetAccount, double amount, String description) {
        if (this == targetAccount) {
            System.out.println("TRANSFER REJECTED: Cannot transfer to same account");
            return false;
        }

        // Prevent deadlock by ordering locks by account number
        BankAccount firstLock = accountNumber.compareTo(targetAccount.accountNumber) < 0 ? this : targetAccount;
        BankAccount secondLock = accountNumber.compareTo(targetAccount.accountNumber) < 0 ? targetAccount : this;

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (this.withdraw(amount, "Transfer to " + targetAccount.accountNumber + ": " + description)) {
                    if (targetAccount.deposit(amount, "Transfer from " + this.accountNumber + ": " + description)) {
                        System.out.println(String.format("TRANSFER COMPLETED: %.2f from %s to %s",
                                amount, this.accountNumber, targetAccount.accountNumber));
                        return true;
                    } else {
                        // Rollback withdrawal if deposit fails
                        this.deposit(amount, "Rollback failed transfer to " + targetAccount.accountNumber);
                        this.deposit(amount, "Rollback failed transfer to " + targetAccount.accountNumber);
                        System.out.println(String.format("TRANSFER FAILED: Deposit to target %s failed. Rolled back.",
                                targetAccount.accountNumber));
                        return false;
                    }
                } else {
                    System.out.println(String.format("TRANSFER FAILED: Withdrawal from %s failed.", this.accountNumber));
                    return false;
                }
            }
        }
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    public synchronized void freezeAccount() {
        this.accountFrozen = true;
        synchronized (balanceMonitor) {
            balanceMonitor.notifyAll(); // Unblock waiting threads
        }
        System.out.println("ACCOUNT FROZEN: " + accountNumber);
    }

    public synchronized void unfreezeAccount() {
        this.accountFrozen = false;
        System.out.println("ACCOUNT UNFROZEN: " + accountNumber);
    }
}
