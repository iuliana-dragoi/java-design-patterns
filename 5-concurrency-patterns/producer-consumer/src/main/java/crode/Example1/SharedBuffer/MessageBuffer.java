package crode.Example1.SharedBuffer;

import crode.Example1.MessageModel.Message;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageBuffer {

    private final BlockingQueue<Message> queue;
    private final int capacity;
    private final AtomicInteger totalProduced = new AtomicInteger(0);
    private final AtomicInteger totalConsumed = new AtomicInteger(0);

    public MessageBuffer(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void put(Message message) throws InterruptedException {
        queue.put(message); // Blocks if queue is full
        totalProduced.incrementAndGet();
        System.out.println("PRODUCED: " + message + " [Queue size: " + queue.size() + "]");
    }

    public Message take() throws InterruptedException {
        Message message = queue.take();
        totalConsumed.incrementAndGet();
        System.out.println("CONSUMED: " + message + " [Queue size: " + queue.size() + "]");
        return message;
    }

    public int size() {
        return queue.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalProduced() {
        return totalProduced.get();
    }

    public int getTotalConsumed() {
        return totalConsumed.get();
    }

    public void printStats() {
        System.out.println(String.format("STATS: Produced=%d, Consumed=%d, Queue size=%d", getTotalProduced(), getTotalConsumed(), size()));
    }
}
