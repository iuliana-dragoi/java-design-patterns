package crode;

import crode.Manager.ImageProcessingThreadPool;

import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Thread Pool Pattern Demo ===");

        // Create thread pool
        ImageProcessingThreadPool pool = new ImageProcessingThreadPool(
                3,  // core pool size
                6,  // maximum pool size
                30  // keep alive time in seconds
        );

        ImageTaskGenerator generator = new ImageTaskGenerator();

        // Demo 1: Individual tasks
        System.out.println("\n1. Processing individual tasks...");
        List<Future<?>> individualTasks = generator.generateRandomTasks(pool, 15);

        // Monitor pool status
        ScheduledExecutorService monitor = Executors.newScheduledThreadPool(1);
        monitor.scheduleAtFixedRate(pool::printPoolStatus, 0, 2, TimeUnit.SECONDS);

        // Wait for individual tasks to complete
        try {
            for (Future<?> future : individualTasks) {
                future.get(); // Wait for completion
            }
            System.out.println("All individual tasks completed!");
        } catch (Exception e) {
            System.err.println("Error waiting for individual tasks: " + e.getMessage());
        }

        // Demo 2: Batch processing
        System.out.println("\n2. Processing batch tasks...");
        List <CompletableFuture<Void>> batchTasks = generator.generateBatchTasks(pool, 5);

        // Wait for batch tasks to complete
        CompletableFuture<Void> allBatches = CompletableFuture.allOf(
                batchTasks.toArray(new CompletableFuture[0])
        );

        try {
            allBatches.get(30, TimeUnit.SECONDS);
            System.out.println("All batch tasks completed!");
        } catch (Exception e) {
            System.err.println("Error waiting for batch tasks: " + e.getMessage());
        }

        // Final statistics
        System.out.println("\n=== Final Statistics ===");
        pool.printPoolStatus();
        System.out.println("Completed batches: " + pool.getCompletedTasks());
        System.out.println("Failed batches: " + pool.getFailedTasks());

        // Cleanup
        monitor.shutdown();
        pool.shutdown();

        System.out.println("Thread Pool Demo completed!");
    }
}
