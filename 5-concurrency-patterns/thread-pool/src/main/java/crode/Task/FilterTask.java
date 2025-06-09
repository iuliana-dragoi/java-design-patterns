package crode.Task;

import crode.Model.ImageProcessingTask;

import java.util.Random;

public class FilterTask extends ImageProcessingTask {

    private final String filterType;
    private final Random random = new Random();

    public FilterTask(String imageName, int taskId, String filterType) {
        super(imageName, taskId);
        this.filterType = filterType;
    }

    @Override
    public void run() {
        logStart();
        long startTime = System.currentTimeMillis();

        try {
            // Different filters take different amounts of time
            int baseTime = switch (filterType) {
                case "BLUR" -> 300;
                case "SHARPEN" -> 500;
                case "SEPIA" -> 700;
                case "GRAYSCALE" -> 200;
                default -> 400;
            };

            int processingTime = baseTime + random.nextInt(300);
            Thread.sleep(processingTime);

            logComplete(System.currentTimeMillis() - startTime);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filter task interrupted for: " + imageName);
        }
    }
}
