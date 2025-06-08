package crode.Commands;

import crode.Command;
import crode.TextEditor;

public class RemoveTextCommand implements Command {

    private TextEditor editor;
    private int length;
    private String removedText;

    public RemoveTextCommand(TextEditor editor, int length) {
        this.editor = editor;
        this.length = length;
    }

    @Override
    public void execute() {
        String content = editor.getContent();
        if(length <= content.length()) {
            removedText = content.substring(content.length() - length);
            editor.removeText(length);
        }
    }

    @Override
    public void undo() {
        if(removedText != null) {
            editor.addText(removedText);
        }
    }
}
