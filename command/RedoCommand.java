package command;

import window.Window;
/**
 * Command (233): ConcreteCommand
 */
public class RedoCommand extends Command {
    public RedoCommand() {
        super(false);
    }

    @Override
    public void execute(Window window) {
        CommandHistory.getInstance().redo(window);
    }
}
