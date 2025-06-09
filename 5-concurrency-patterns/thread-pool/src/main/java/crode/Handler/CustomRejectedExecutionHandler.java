package crode.Handler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.err.println("Task rejected: " + r.toString());
        System.err.println("Pool status: " + executor.toString());

        // Try to run in calling thread as fallback
        if (!executor.isShutdown()) {
            try {
                r.run();
            } catch (Exception e) {
                System.err.println("Failed to execute rejected task: " + e.getMessage());
            }
        }
    }
}