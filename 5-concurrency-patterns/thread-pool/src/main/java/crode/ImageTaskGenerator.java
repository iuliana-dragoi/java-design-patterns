package crode;

import crode.Manager.ImageProcessingThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ImageTaskGenerator {

    private final String[] imageNames = {
            "landscape.jpg", "portrait.jpg", "nature.jpg", "city.jpg", "sunset.jpg",
            "mountain.jpg", "beach.jpg", "forest.jpg", "architecture.jpg", "street.jpg"
    };

    private final String[] filterTypes = {"BLUR", "SHARPEN", "SEPIA", "GRAYSCALE"};
    private final String[] compressionLevels = {"LOW", "MEDIUM", "HIGH"};
    private final Random random = new Random();

    public List<Future<?>> generateRandomTasks(ImageProcessingThreadPool pool, int taskCount) {
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < taskCount; i++) {
            String imageName = imageNames[random.nextInt(imageNames.length)];

            Future<?> future = switch (random.nextInt(3)) {
                case 0 -> pool.submitResizeTask(imageName,
                        random.nextInt(1000) + 500,
                        random.nextInt(1000) + 500);
                case 1 -> pool.submitFilterTask(imageName,
                        filterTypes[random.nextInt(filterTypes.length)]);
                case 2 -> pool.submitCompressionTask(imageName,
                        compressionLevels[random.nextInt(compressionLevels.length)]);
                default -> throw new IllegalStateException("Unexpected value");
            };

            futures.add(future);
        }

        return futures;
    }

    public List<CompletableFuture<Void>> generateBatchTasks(ImageProcessingThreadPool pool, int batchCount) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < batchCount; i++) {
            String imageName = imageNames[random.nextInt(imageNames.length)];
            futures.add(pool.submitBatchProcessing(imageName));
        }

        return futures;
    }
}
