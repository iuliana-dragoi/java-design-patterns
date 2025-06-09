package crode.Task;

import crode.Model.ImageProcessingTask;

import java.util.Random;

public class CompressionTask extends ImageProcessingTask {

    private final String compressionLevel;
    private final Random random = new Random();

    public CompressionTask(String imageName, int taskId, String compressionLevel) {
        super(imageName, taskId);
        this.compressionLevel = compressionLevel;
    }

    @Override
    public void run() {
        logStart();
        long startTime = System.currentTimeMillis();

        try {
            // Compression time varies by level
            int baseTime = switch (compressionLevel) {
                case "LOW" -> 200;
                case "MEDIUM" -> 600;
                case "HIGH" -> 1200;
                default -> 500;
            };

            int processingTime = baseTime + random.nextInt(200);
            Thread.sleep(processingTime);

            logComplete(System.currentTimeMillis() - startTime);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Compression task interrupted for: " + imageName);
        }
    }
}
