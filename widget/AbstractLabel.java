package widget;
import formatting.Cursor;
import glyph.*;
import window.Window;

/**
 * Abstract Product in Abstract Factory pattern (87)
 */

public abstract class AbstractLabel extends Embellishment {
    public AbstractLabel(Window window, Glyph child) {
        super(window, child);
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateWidth(child.getBounds().getWidth());
        curs.updateHeight(child.getBounds().getHeight());
        return curs;
    }


}
