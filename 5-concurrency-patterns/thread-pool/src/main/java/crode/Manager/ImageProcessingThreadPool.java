package crode.Manager;

import crode.Factory.CustomThreadFactory;
import crode.Handler.CustomRejectedExecutionHandler;
import crode.Task.CompressionTask;
import crode.Task.FilterTask;
import crode.Task.ResizeTask;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ImageProcessingThreadPool {

    private final ExecutorService executor;
    private final int corePoolSize;
    private final int maximumPoolSize;
    private final long keepAliveTime;
    private final AtomicInteger taskIdGenerator = new AtomicInteger(1);
    private final AtomicInteger completedTasks = new AtomicInteger(0);
    private final AtomicInteger failedTasks = new AtomicInteger(0);

    public ImageProcessingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;

        // Create custom ThreadPoolExecutor
        this.executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler()
        );
    }

    public Future<?> submitResizeTask(String imageName, int width, int height) {
        ResizeTask task = new ResizeTask(imageName, taskIdGenerator.getAndIncrement(), width, height);
        return executor.submit(task);
    }

    public Future<?> submitFilterTask(String imageName, String filterType) {
        FilterTask task = new FilterTask(imageName, taskIdGenerator.getAndIncrement(), filterType);
        return executor.submit(task);
    }

    public Future<?> submitCompressionTask(String imageName, String compressionLevel) {
        CompressionTask task = new CompressionTask(imageName, taskIdGenerator.getAndIncrement(), compressionLevel);
        return executor.submit(task);
    }

    public CompletableFuture<Void> submitBatchProcessing(String imageName) {
        // Process image through multiple stages
        return CompletableFuture.runAsync(() -> {
            try {
                // Stage 1: Resize
                ResizeTask resizeTask = new ResizeTask(imageName, taskIdGenerator.getAndIncrement(), 800, 600);
                resizeTask.run();

                // Stage 2: Apply filter
                FilterTask filterTask = new FilterTask(imageName, taskIdGenerator.getAndIncrement(), "BLUR");
                filterTask.run();

                // Stage 3: Compress
                CompressionTask compressTask = new CompressionTask(imageName, taskIdGenerator.getAndIncrement(), "MEDIUM");
                compressTask.run();

                completedTasks.incrementAndGet();
                System.out.println("BATCH COMPLETED for: " + imageName);

            } catch (Exception e) {
                failedTasks.incrementAndGet();
                System.err.println("BATCH FAILED for: " + imageName + " - " + e.getMessage());
            }
        }, executor);
    }

    public void printPoolStatus() {
        if (executor instanceof ThreadPoolExecutor tpe) {
            System.out.println(String.format(
                    "Pool Status: Active=%d, Pool Size=%d, Queue Size=%d, Completed=%d",
                    tpe.getActiveCount(),
                    tpe.getPoolSize(),
                    tpe.getQueue().size(),
                    tpe.getCompletedTaskCount()
            ));
        }
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public int getCompletedTasks() { return completedTasks.get(); }
    public int getFailedTasks() { return failedTasks.get(); }
}
