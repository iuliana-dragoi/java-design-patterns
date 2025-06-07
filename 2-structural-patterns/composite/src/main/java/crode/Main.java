package crode;

import crode.Builder.FileSystemBuilder;
import crode.Composite.Directory;
import crode.Leaf.File;
import crode.Manager.FileManager;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Composite Pattern Demo ===\n");

        Directory root = FileSystemBuilder.createSampleFileSystem();
        FileManager manager = new FileManager(root);

        manager.showFileSystem();
        manager.showStatistics();

        manager.searchFiles("JPEG");
        manager.searchFiles("MP3");
        manager.searchFiles("PDF");

        manager.demonstrateUniformTreatment();

        System.out.println("\n=== Dynamic Operations ===");
        Directory newFolder = new Directory("NewFolder");
        newFolder.add(new File("newfile.txt", 512, "Text"));
        newFolder.add(new File("newimage.png", 1024000, "PNG"));

        root.add(newFolder);
        System.out.println("Added new folder:");
        newFolder.display(0);

        System.out.println("\nUpdated statistics:");
        manager.showStatistics();

        System.out.println("\n=== File Operations ===");
        File testFile = new File("test.txt", 100, "Text");
        testFile.display(0);
        testFile.open();
        testFile.close();

        System.out.println("\n=== Error Handling ===");
        try {
            testFile.add(new File("invalid.txt", 50, "Text"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        try {
            newFolder.open();
        } catch (UnsupportedOperationException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

    }
}
