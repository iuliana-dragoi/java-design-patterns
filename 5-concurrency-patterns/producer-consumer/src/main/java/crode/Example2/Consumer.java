package crode.Example2;

public class Consumer implements Runnable {

    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.consume();
                Thread.sleep(600); // Process Simulation
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
