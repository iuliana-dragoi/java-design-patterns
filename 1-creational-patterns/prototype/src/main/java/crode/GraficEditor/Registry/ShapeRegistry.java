package crode.GraficEditor.Registry;

import crode.GraficEditor.Shape;
import crode.GraficEditor.Shapes.Circle;
import crode.GraficEditor.Shapes.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {

    private Map<String, Shape> prototypes = new HashMap<>();

    public void registerPrototype(String key, Shape prototype) {
        prototypes.put(key, prototype);
    }

    public Shape getPrototype(String key) {
        Shape shape = prototypes.get(key);
        return shape != null ? shape.clone() : null;
    }

    public void loadDefaultPrototypes() {
        registerPrototype("small_red_circle", new Circle(0,0,10, "Red"));
        registerPrototype("large_blue_circle", new Circle(0, 0, 50, "Blue"));

        registerPrototype("small_solid_rect", new Rectangle(0, 0, 20, 15, "Solid"));
        registerPrototype("large_striped_rect", new Rectangle(0, 0, 100, 80, "Striped"));
    }
}
