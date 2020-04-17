package command;

import window.Window;

public class UndoCommand extends Command {
    public UndoCommand() {
        super(false);
    }

    @Override
    public void execute(Window window) {
        CommandHistory.getInstance().undo(window);
    }
}
