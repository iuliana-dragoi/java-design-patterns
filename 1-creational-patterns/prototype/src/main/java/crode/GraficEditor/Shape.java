package crode.GraficEditor;

public interface Shape extends Cloneable {
    Shape clone();
    void draw();
    void setPosition(int x, int y);
}
