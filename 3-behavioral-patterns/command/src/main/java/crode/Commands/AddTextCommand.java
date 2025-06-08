package crode.Commands;

import crode.Command;
import crode.TextEditor;

public class AddTextCommand implements Command {

    private TextEditor editor;
    private String text;

    public AddTextCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.addText(text);
    }

    @Override
    public void undo() {
        editor.removeText(text.length());
    }
}
