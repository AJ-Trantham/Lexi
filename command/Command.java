package command;
import exceptions.OperationNotSupported;
import window.*;

/**
 * Prototype(117): Prototype
 * Command(233): Command
 * */
public abstract class Command {
    // protected Glyph state;  Not sure what this should be, could be the root glyph and we could redraw but that is not very efficient
    // could be specific to cmd as well
    private boolean undoable;

    Command(boolean undoable) {
        this.undoable = undoable;
    }

    public boolean isUndoable() {
        return  undoable;
    }

    public Command copy() throws OperationNotSupported{
        throw new OperationNotSupported();
    }

    public abstract void execute(Window window);
    public void unexecute(Window window) {
        throw new UnsupportedOperationException();
    }

}
