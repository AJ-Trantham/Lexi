package command;

import window.Window;

public class RedoCommand extends Command {
    public RedoCommand() {
        super(false);
    }

    @Override
    public void execute(Window window) {
        CommandHistory.getInstance().redo(window);
    }
}
