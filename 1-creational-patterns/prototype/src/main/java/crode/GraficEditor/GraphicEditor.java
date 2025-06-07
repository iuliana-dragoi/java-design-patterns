package crode.GraficEditor;

import crode.GraficEditor.Registry.ShapeRegistry;

import java.util.ArrayList;
import java.util.List;

public class GraphicEditor {

    private ShapeRegistry registry;
    private List<Shape> canvas;

    public GraphicEditor() {
        registry = new ShapeRegistry();
        registry.loadDefaultPrototypes();
        canvas = new ArrayList<>();
    }

    public void addShapeFromPrototype(String prototypeKey, int x, int y) {
        Shape shape = registry.getPrototype(prototypeKey);
        if (shape != null) {
            shape.setPosition(x, y);
            canvas.add(shape);
            System.out.println("Added shape from prototype '" + prototypeKey + "' at position (" + x + "," + y + ")");
        } else {
            System.out.println("Prototype '" + prototypeKey + "' not found!");
        }
    }

    public void duplicateLastShape(int offsetX, int offsetY) {
        if (!canvas.isEmpty()) {
            Shape lastShape = canvas.get(canvas.size() - 1);
            Shape duplicate = lastShape.clone();
            duplicate.setPosition(offsetX, offsetY);
            canvas.add(duplicate);
            System.out.println("Duplicated last shape with offset (" + offsetX + "," + offsetY + ")");
        }
    }

    public void drawCanvas() {
        System.out.println("\n--- Canvas Contents ---");
        if (canvas.isEmpty()) {
            System.out.println("Canvas is empty");
            return;
        }
        for (int i = 0; i < canvas.size(); i++) {
            System.out.print((i + 1) + ". ");
            canvas.get(i).draw();
        }
    }

    public void clearCanvas() {
        canvas.clear();
        System.out.println("Canvas cleared");
    }
}
