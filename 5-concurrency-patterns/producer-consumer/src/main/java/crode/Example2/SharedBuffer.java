package crode.Example2;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int CAPACITY = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == CAPACITY) {
            wait(); // Waits if the buffer is full
        }

        buffer.add(value);
        System.out.println("Produced: " + value);
        notify(); // Notifies a consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // Waits if the buffer is empty
        }

        int value = buffer.poll();
        System.out.println("Consumed: " + value);
        notify(); // Notifies a producer
        return value;
    }

    // synchronized – ensures only one thread accesses the method at a time
    // wait() – makes the thread wait if it cannot continue (buffer full/empty)
    // notify() – wakes up a waiting thread
}
