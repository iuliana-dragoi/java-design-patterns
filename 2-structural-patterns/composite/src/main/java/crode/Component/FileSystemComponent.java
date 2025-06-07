package crode.Component;

import java.util.List;

// The abstract component
public abstract class FileSystemComponent {

    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Common operations
    public abstract void display(int indent);
    public abstract long getSize();

    // Operations for composite (directory)
    // Default implementation that throws exception
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add to a file");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a file");
    }

    public FileSystemComponent getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from a file");
    }

    public List<FileSystemComponent> getChildren() {
        throw new UnsupportedOperationException("Cannot get children from a file");
    }

    // Leaf operations (file)
    public void open() {
        throw new UnsupportedOperationException("Cannot open a directory");
    }

    public void close() {
        throw new UnsupportedOperationException("Cannot close a directory");
    }

    // Indentation helper
    protected String getIndent(int level) {
        return "  ".repeat(level);
    }
}
