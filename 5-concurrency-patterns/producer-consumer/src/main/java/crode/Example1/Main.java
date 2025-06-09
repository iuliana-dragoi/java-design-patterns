package crode.Example1;

import crode.Example1.Consumer.MessageConsumer;
import crode.Example1.Monitor.BufferMonitor;
import crode.Example1.Producer.MessageProducer;
import crode.Example1.SharedBuffer.MessageBuffer;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Producer-Consumer Pattern Demo ===");

        // Configuration
        final int BUFFER_CAPACITY = 10;
        final int MESSAGES_PER_PRODUCER = 8;
        final int MESSAGES_PER_CONSUMER = 6;
        final int NUM_PRODUCERS = 2;
        final int NUM_CONSUMERS = 3;

        // Create shared buffer
        MessageBuffer buffer = new MessageBuffer(BUFFER_CAPACITY);

        // Create and start monitor
        BufferMonitor monitor = new BufferMonitor(buffer, 2000); // Monitor every 2 seconds
        Thread monitorThread = new Thread(monitor, "BufferMonitor");
        monitorThread.setDaemon(true);
        monitorThread.start();

        // Create producer threads
        Thread[] producerThreads = new Thread[NUM_PRODUCERS];
        for (int i = 0; i < NUM_PRODUCERS; i++) {
            MessageProducer producer = new MessageProducer(buffer, "Producer-" + (i + 1), MESSAGES_PER_PRODUCER);
            producerThreads[i] = new Thread(producer, "ProducerThread-" + (i + 1));
        }

        // Create consumer threads
        Thread[] consumerThreads = new Thread[NUM_CONSUMERS];
        MessageConsumer[] consumers = new MessageConsumer[NUM_CONSUMERS];
        for (int i = 0; i < NUM_CONSUMERS; i++) {
            consumers[i] = new MessageConsumer(buffer, "Consumer-" + (i + 1), MESSAGES_PER_CONSUMER);
            consumerThreads[i] = new Thread(consumers[i], "ConsumerThread-" + (i + 1));
        }

        // Start all threads
        System.out.println("Starting producers and consumers...");
        for (Thread producer : producerThreads) {
            producer.start();
        }
        for (Thread consumer : consumerThreads) {
            consumer.start();
        }

        // Wait for all producers to finish
        try {
            for (Thread producer : producerThreads) {
                producer.join();
            }
            System.out.println("All producers finished!");

            // Wait for all consumers to finish
            for (Thread consumer : consumerThreads) {
                consumer.join();
            }
            System.out.println("All consumers finished!");

            // Stop monitor
            monitor.stop();

            // Final statistics
            System.out.println("\n=== Final Statistics ===");
            buffer.printStats();

        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
            Thread.currentThread().interrupt();
        }

        System.out.println("Demo completed!");
    }
}
