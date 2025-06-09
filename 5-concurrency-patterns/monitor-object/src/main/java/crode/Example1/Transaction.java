package crode.Example1;

public class Transaction {
    private final long id;
    private final TransactionType type;
    private final double amount;
    private final double oldBalance;
    private final double newBalance;
    private final String description;

    public Transaction(long id, TransactionType type, double amount,
                       double oldBalance, double newBalance, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getOldBalance() {
        return oldBalance;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Transaction #%d [%s] - Amount: %.2f | From: %.2f -> To: %.2f | %s",
                id, type, amount, oldBalance, newBalance, description);
    }
}

