package crode.GraficEditor.Shapes;

import crode.GraficEditor.Shape;

public class Rectangle implements Shape {

    private int x, y;
    private int width, height;
    private String fillPattern;

    public Rectangle(int x, int y, int width, int height, String fillPattern) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fillPattern = fillPattern;
    }

    private Rectangle(Rectangle other) {
        this.x = other.x;
        this.y = other.y;
        this.width = other.width;
        this.height = other.height;
        this.fillPattern = other.fillPattern;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle at (" + x + "," + y + ") size " + width + "x" + height + " with pattern: " + fillPattern);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setFillPattern(String pattern) { this.fillPattern = pattern; }
}
