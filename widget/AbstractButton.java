package widget;
import command.Command;
import exceptions.OperationNotSupported;
import formatting.Cursor;
import glyph.*;
import window.*;

/**
 * Abstract Product in Abstract Factory pattern (87)
 */

public abstract class AbstractButton extends Embellishment {
    private final int buttonPadding = 1;

    public AbstractButton(Window window, Glyph child) {
        super(window, child);
    }

    public AbstractButton(Window window, Glyph child, Command cmd) {
        super(window, child);
        setCommand(cmd);
    }

    public void setCommand(Command cmd) {
        command = cmd;
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateWidth( child.getBounds().getWidth() + buttonPadding);
        curs.updateHeight(child.getBounds().getHeight() + buttonPadding);
        return curs;
    }

    @Override
    public Glyph find(int x, int y) {
        return this;
    }

    @Override
    public Command click() throws OperationNotSupported {
        return command;
    }
}
