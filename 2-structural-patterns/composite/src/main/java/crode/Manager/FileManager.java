package crode.Manager;

import crode.Component.FileSystemComponent;
import crode.Composite.Directory;
import crode.Leaf.File;

import java.util.List;

public class FileManager {

    private Directory root;

    public FileManager(Directory root) {
        this.root = root;
    }

    public void showFileSystem() {
        System.out.println("=== File System Structure ===");
        root.display(0);
    }

    public void showStatistics() {
        System.out.println("\n=== File System Statistics ===");
        System.out.println("Total size: " + formatBytes(root.getSize()));
        System.out.println("Total files: " + root.getFileCount());
        System.out.println("Total directories: " + (root.getDirectoryCount() + 1)); // +1 for root
    }

    public void searchFiles(String type) {
        System.out.println("\n=== Files of type: " + type + " ===");
        List<File> files = root.findFilesByType(type);
        if (files.isEmpty()) {
            System.out.println("No files found of type: " + type);
        } else {
            for (File file : files) {
                System.out.println("Found: " + file.getName() + " (" + formatBytes(file.getSize()) + ")");
            }
        }
    }

    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return (bytes / 1024) + " KB";
        return (bytes / (1024 * 1024)) + " MB";
    }

    public void demonstrateUniformTreatment() {
        System.out.println("\n=== Uniform Treatment Demo ===");
        System.out.println("Treating files and directories the same way:");

        List<FileSystemComponent> components = root.getChildren();
        for (FileSystemComponent component : components) {
            System.out.println("- " + component.getName() + ": " + formatBytes(component.getSize()));
        }
    }
}
