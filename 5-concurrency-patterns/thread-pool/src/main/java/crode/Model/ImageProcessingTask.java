package crode.Model;

public abstract class ImageProcessingTask implements Runnable {

    protected final String imageName;
    protected final int taskId;
    protected final long submissionTime;

    public ImageProcessingTask(String imageName, int taskId) {
        this.imageName = imageName;
        this.taskId = taskId;
        this.submissionTime = System.currentTimeMillis();
    }


    public String getImageName() { return imageName; }
    public int getTaskId() { return taskId; }
    public long getSubmissionTime() { return submissionTime; }

    protected void logStart() {
        System.out.println(String.format("[%s] Starting %s for image: %s",
                Thread.currentThread().getName(),
                getClass().getSimpleName(),
                imageName));
    }

    protected void logComplete(long processingTime) {
        long totalTime = System.currentTimeMillis() - submissionTime;
        System.out.println(String.format("[%s] Completed %s for image: %s (Processing: %dms, Total: %dms)",
                Thread.currentThread().getName(),
                getClass().getSimpleName(),
                imageName, processingTime, totalTime));
    }
}
