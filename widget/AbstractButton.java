package widget;
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

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateWidth( child.getBounds().getWidth() + buttonPadding);
        curs.updateHeight(child.getBounds().getHeight() + buttonPadding);
        return curs;
    }
}
