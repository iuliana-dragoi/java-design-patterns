package crode.Example1.Monitor;

import crode.Example1.SharedBuffer.MessageBuffer;

public class BufferMonitor implements Runnable {

    private final MessageBuffer buffer;
    private final long monitorInterval;
    private volatile boolean running = true;

    public BufferMonitor(MessageBuffer buffer, long monitorInterval) {
        this.buffer = buffer;
        this.monitorInterval = monitorInterval;
    }

    @Override
    public void run() {
        try {
            while (running) {
                Thread.sleep(monitorInterval);
                buffer.printStats();

                // Alert if buffer is getting full
                if (buffer.size() > buffer.getCapacity() * 0.8) {
                    System.out.println("WARNING: Buffer is 80% full!");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Buffer monitor was interrupted");
        }
    }

    public void stop() {
        running = false;
    }
}
