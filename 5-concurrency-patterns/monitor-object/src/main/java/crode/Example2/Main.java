package crode.Example2;

public class Main {

    // synchronized ensures that only one thread at a time can access put() or take().
    // wait() temporarily stops the thread if the condition is not met.
    // notify() wakes up a waiting thread.

    public static void main(String[] args) {
        MessageBox box = new MessageBox();

        // Producer
        Thread producer = new Thread(() -> {
            String[] messages = { "Hello", "World", "Monitor", "Object", "Done" };
            for (String msg : messages) {
                box.put(msg);
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        });

        // Consumer
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String msg = box.take();
                try { Thread.sleep(800); } catch (InterruptedException ignored) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
