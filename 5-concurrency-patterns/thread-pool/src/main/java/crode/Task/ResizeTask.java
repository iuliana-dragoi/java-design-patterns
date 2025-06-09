package crode.Task;

import crode.Model.ImageProcessingTask;

import java.util.Random;

public class ResizeTask extends ImageProcessingTask {

    private final int width, height;
    private final Random random = new Random();

    public ResizeTask(String imageName, int taskId, int width, int height) {
        super(imageName, taskId);
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        logStart();
        long startTime = System.currentTimeMillis();

        try {
            // Simulate image resizing
            int processingTime = random.nextInt(1000) + 500; // 500-1500ms
            Thread.sleep(processingTime);

            // Simulate potential failure
            if (random.nextDouble() < 0.05) { // 5% failure rate
                throw new RuntimeException("Resize failed for " + imageName);
            }

            logComplete(System.currentTimeMillis() - startTime);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Resize task interrupted for: " + imageName);
        } catch (Exception e) {
            System.err.println("ERROR in resize task: " + e.getMessage());
        }
    }
}
