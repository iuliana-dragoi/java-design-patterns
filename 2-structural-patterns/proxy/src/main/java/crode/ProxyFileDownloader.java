package crode;

import java.util.HashSet;
import java.util.Set;

public class ProxyFileDownloader implements FileDownloader {

    private RealFileDownloader realFileDownloader;
    private Set<String> downloadedFiles = new HashSet<>();
    private String userRole;

    public ProxyFileDownloader(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void downloadFile(String filename) {

        // Proxy Protection - verify permissions
        if(!"ADMIN".equals(userRole) && filename.endsWith(".exe")) {
            System.out.println("Access denied! You cannot download .exe files!");
            return;
        }

        // Virtual Proxy
        if(downloadedFiles.contains(filename)) {
            System.out.println("File " + filename + " is already in cache!");
            return;
        }

        // Lazy initialization
        if(realFileDownloader == null) {
            System.out.println("Connection initialization...");
            realFileDownloader = new RealFileDownloader();
        }

        realFileDownloader.downloadFile(filename);
        downloadedFiles.add(filename);
    }
}
