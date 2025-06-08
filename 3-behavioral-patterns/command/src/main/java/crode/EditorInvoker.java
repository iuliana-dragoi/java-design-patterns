package crode;

import java.util.Stack;

public class EditorInvoker {

    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if(!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        }
        else {
            System.out.println("No more commands!");
        }
    }

}
