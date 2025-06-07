package crode.Leaf;

import crode.Component.FileSystemComponent;

// Leaf - Simple File
public class File extends FileSystemComponent {

    private long size;
    private String type;
    private boolean isOpen = false;

    public File(String name, long size, String type) {
        super(name);
        this.size = size;
        this.type = type;
    }


    @Override
    public void display(int indent) {
        System.out.println(getIndent(indent) + " " + name + " (" + size + " bytes, " + type + ")");
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void open() {
        isOpen = true;
        System.out.println("Opening file: " + name);
    }

    @Override
    public void close() {
        isOpen = false;
        System.out.println("Closing file: " + name);
    }

    public String getType() {
        return type;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
