package crode.Composite;

import crode.Leaf.File;
import crode.Component.FileSystemComponent;

import java.util.ArrayList;
import java.util.List;

// Composite - Director
public class Directory extends FileSystemComponent {

    private List<FileSystemComponent> children;

    public Directory(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public FileSystemComponent getChild(int index) {
        if(index >= 0 && index > children.size()) {
            return children.get(index);
        }
        return null;
    }

    @Override
    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public void display(int indent) {
        System.out.println(getIndent(indent) + " " + name + "/ (" +
                children.size() + " items, " + getSize() + " bytes total)");

        // Displays children recursively
        for (FileSystemComponent child : children) {
            child.display(indent + 1);
        }
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for(FileSystemComponent child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    public int getFileCount() {
        int count = 0;
        for(FileSystemComponent child : children) {
            if(child instanceof File) {
                count++;
            }
            else if(child instanceof Directory) {
                count += ((Directory) child).getFileCount();
            }
        }
        return count;
    }

    public int getDirectoryCount() {
        int count = 0;
        for (FileSystemComponent child : children) {
            if (child instanceof Directory) {
                count++;
                count += ((Directory) child).getDirectoryCount();
            }
        }
        return count;
    }

    public List<File> findFilesByType(String type) {
        List<File> foundFiles = new ArrayList<>();
        for (FileSystemComponent child : children) {
            if (child instanceof File && ((File) child).getType().equals(type)) {
                foundFiles.add((File) child);
            } else if (child instanceof Directory) {
                foundFiles.addAll(((Directory) child).findFilesByType(type));
            }
        }
        return foundFiles;
    }
}
