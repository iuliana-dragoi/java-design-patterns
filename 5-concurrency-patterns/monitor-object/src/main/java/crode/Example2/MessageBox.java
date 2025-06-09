package crode.Example2;

public class MessageBox {

    private String message;
    private boolean hasMessage = false;

    // Put a message in the box (called by the producer)
    public synchronized void put(String msg) {
        while (hasMessage) {
            try {
                wait(); // Wait for the previous message to be consumed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        message = msg;
        hasMessage = true;
        System.out.println("Produced: " + msg);
        notify(); // Notify the consumer
    }

    // Get message from box (called by consumer)
    public synchronized String take() {
        while (!hasMessage) {
            try {
                wait(); // Wait until message is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        hasMessage = false;
        notify(); // Notify producer that message has been consumed
        System.out.println("Consumed: " + message);
        return message;
    }

}
