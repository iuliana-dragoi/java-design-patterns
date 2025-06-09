package crode.Example1.Producer;

import crode.Example1.MessageModel.Message;
import crode.Example1.SharedBuffer.MessageBuffer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageProducer implements Runnable {

    private final MessageBuffer buffer;
    private final String producerName;
    private final int messagesToProduce;
    private final Random random = new Random();
    private final AtomicInteger messageIdGenerator = new AtomicInteger(1);

    public MessageProducer(MessageBuffer buffer, String producerName, int messagesToProduce) {
        this.buffer = buffer;
        this.producerName = producerName;
        this.messagesToProduce = messagesToProduce;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < messagesToProduce; i++) {
                // Simulate message creation time
                Thread.sleep(random.nextInt(1000) + 500); // 500-1500ms

                Message message = createMessage();
                buffer.put(message);

                // Random pause between messages
                if (random.nextBoolean()) {
                    Thread.sleep(random.nextInt(300));
                }
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(producerName + " was interrupted");
        }
    }

    private Message createMessage() {
        int id = messageIdGenerator.getAndIncrement();
        String[] priorities = {"HIGH", "MEDIUM", "LOW"};
        String priority = priorities[random.nextInt(priorities.length)];
        String content = String.format("Message from %s - Task #%d", producerName, id);

        return new Message(id, content, priority);
    }
}
