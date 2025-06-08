package crode;

import crode.Commands.AddTextCommand;
import crode.Commands.RemoveTextCommand;

public class Main {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorInvoker invoker = new EditorInvoker();

        System.out.println("=== Command Pattern Demo ===");

        Command addHello = new AddTextCommand(editor, "Hello ");
        Command addWorld = new AddTextCommand(editor, "World!");

        invoker.executeCommand(addHello);
        System.out.println("After 'Hello ': " + editor.getContent());

        invoker.executeCommand(addWorld);
        System.out.println("After 'World!': " + editor.getContent());

        Command remove6 = new RemoveTextCommand(editor, 6);
        invoker.executeCommand(remove6);
        System.out.println("After removing 6 characters: " + editor.getContent());

        System.out.println("\n=== Undo Operations ===");
        invoker.undo();
        System.out.println("After first undo: " + editor.getContent());

        invoker.undo();
        System.out.println("After second undo: " + editor.getContent());

        invoker.undo();
        System.out.println("After third undo: " + editor.getContent());

        invoker.undo();
    }
}
