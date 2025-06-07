package crode.GraficEditor.Shapes;

import crode.GraficEditor.Shape;

public class Circle implements Shape {

    private int x, y;
    private int radius;
    private String color;

    public Circle(int x, int y, int radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    // Deep copy
    private Circle(Circle other) {
        this.x = other.x;
        this.y = other.y;
        this.radius = other.radius;
        this.color = other.color;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle at (" + x + "," + y + ") with radius " + radius + " in " + color);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setRadius(int radius) { this.radius = radius; }
    public void setColor(String color) { this.color = color; }
}
