package crode.Example1.Consumer;

import crode.Example1.MessageModel.Message;
import crode.Example1.SharedBuffer.MessageBuffer;

import java.util.Random;

public class MessageConsumer implements Runnable {

    private final MessageBuffer buffer;
    private final String consumerName;
    private final int messagesToConsume;
    private final Random random = new Random();
    private volatile boolean running = true;

    public MessageConsumer(MessageBuffer buffer, String consumerName, int messagesToConsume) {
        this.buffer = buffer;
        this.consumerName = consumerName;
        this.messagesToConsume = messagesToConsume;
    }

    @Override
    public void run() {
        try {
            int consumed = 0;
            while (running && consumed < messagesToConsume) {
                Message message = buffer.take();
                processMessage(message);
                consumed++;

                // Random processing delay
                Thread.sleep(random.nextInt(800) + 200); // 200-1000ms
            }
            System.out.println(consumerName + " finished consuming " + consumed + " messages");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(consumerName + " was interrupted");
        }
    }

    private void processMessage(Message message) throws InterruptedException {
        // Simulate message processing based on priority
        int processingTime = switch (message.getPriority()) {
            case "HIGH" -> random.nextInt(200) + 100;    // 100-300ms
            case "MEDIUM" -> random.nextInt(400) + 200;  // 200-600ms
            case "LOW" -> random.nextInt(600) + 300;     // 300-900ms
            default -> 500;
        };

        Thread.sleep(processingTime);
        System.out.println(String.format("%s processed %s in %dms",
                consumerName, message, processingTime));
    }

    public void stop() {
        running = false;
    }
}
