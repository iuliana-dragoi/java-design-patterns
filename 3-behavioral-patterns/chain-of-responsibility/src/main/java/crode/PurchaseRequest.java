package crode;

public class PurchaseRequest {

    private String item;
    private double amount;
    private String requester;

    public PurchaseRequest(String item, double amount, String requester) {
        this.item = item;
        this.amount = amount;
        this.requester = requester;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    public String getRequester() {
        return requester;
    }
}
