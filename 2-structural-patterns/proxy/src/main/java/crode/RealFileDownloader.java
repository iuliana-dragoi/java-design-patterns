package crode;

public class RealFileDownloader implements FileDownloader {

    @Override
    public void downloadFile(String filename) {
        System.out.println("Connect to server...");
        System.out.println("Download file: " + filename);
        //Simulate delay
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Complete download for: " + filename);
    }
}
