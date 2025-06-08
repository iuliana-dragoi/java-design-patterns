package crode;

// Receiver - the object which executes the action
public class TextEditor {

    private StringBuilder content = new StringBuilder();

    public void addText(String text) {
        content.append(text);
    }

    public void removeText(int length) {
        if(length <= content.length()) {
            content.delete(content.length() - length, content.length());
        }
    }

    public String getContent() {
        return content.toString();
    }

    public void clear() {
        content.setLength(0);
    }
}
