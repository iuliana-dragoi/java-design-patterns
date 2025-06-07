package crode.GraficEditor;

import crode.GraficEditor.Shapes.Circle;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern Demo ===\n");

        GraphicEditor editor = new GraphicEditor();
        editor.addShapeFromPrototype("small_red_circle", 10, 20);
        editor.addShapeFromPrototype("large_blue_circle", 50, 60);
        editor.addShapeFromPrototype("small_solid_rect", 100, 30);
        editor.drawCanvas();

        System.out.println("\n--- Duplicating Last Shape ---");
        editor.duplicateLastShape(120, 50);
        editor.duplicateLastShape(-12, 88);
        editor.drawCanvas();

        System.out.println("\n--- Testing Independence ---");
        Shape original = new Circle(0, 0, 25, "Green");
        Shape clone1 = original.clone();
        Shape clone2 = original.clone();

        clone1.setPosition(10, 10);
        clone2.setPosition(30, 30);
        ((Circle)clone2).setColor("Purple");

        System.out.println("Original: ");
        original.draw();

        System.out.println("Clone 1: ");
        clone1.draw();

        System.out.println("Clone 2: ");
        clone2.draw();

        System.out.println("\n--- Error Handling ---");
        editor.addShapeFromPrototype("nonexistent_shape", 0, 0);
    }
}
