package crode.Example2;

public class Producer implements Runnable {

    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int value = 1;
        try {
            while (value <= 10) {
                buffer.produce(value++);
                Thread.sleep(300); // Process Simulation
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
