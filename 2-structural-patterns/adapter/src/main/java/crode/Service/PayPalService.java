package crode.Service;

// External Service PayPal (Adaptee) - does not implement our interface.
public class PayPalService {

    public void makePayment(double amountInUSD) {
        System.out.println("Processing $" + amountInUSD + " payment via PayPal");
        // Process Simulation
    }

    public String getPayPalTransactionId() {
        return "PP_" + System.currentTimeMillis();
    }

    public boolean isPaymentSuccessful() {
        return Math.random() > 0.1; // 90% success rate
    }
}
