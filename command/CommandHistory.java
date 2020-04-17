package command;

import exceptions.OperationNotSupported;
import window.Window;

import java.util.Vector;
/**
 * Command (233): Invoker and Receiver - for Undo/Redo Commands
 * This needs to be a singleton -- could relax to have a separate cmd history for each window if we had multiple
 */
public class CommandHistory {
    private static CommandHistory commandHistory;
    private Vector<Command> commands;
    private  int presentIndex; // static, consequence of Singleton

    private CommandHistory () {
        commands = new Vector<>();
        presentIndex = 0;
    }

    public static CommandHistory getInstance() {
        if (commandHistory == null) {
            commandHistory = new CommandHistory();
        }
        return commandHistory;
    }

    public void add(Command cmd) {
        // if a user tries to add a command that is undoable cmd.copy will error and Command will not be added
        try {
            Command copy = cmd.copy();
            // purge the extra commands if necessary - we want the next cmd to be the one that was just added
            if (presentIndex < commands.size()) {
                for (int i=presentIndex; i <commands.size(); i++) {
                    commands.removeElementAt(i);
                }
            }
            commands.add(commands.size(), copy);
            presentIndex = commands.size();
        } catch (OperationNotSupported operationNotSupported) {
            operationNotSupported.printStackTrace();
        }
    }

    void undo(Window window) {
        if (presentIndex-1 >= 0) {
            presentIndex--;
            commands.get(presentIndex).unexecute(window);
        }
    }

    void redo(Window window) {
        if (presentIndex < commands.size()) {
            // unexecuted what has already been unexectuing, two wrongs make a right sort of deal
            commands.get(presentIndex).unexecute(window);
            presentIndex++;
        }
    }
}
