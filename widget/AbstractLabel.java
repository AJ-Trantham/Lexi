package widget;
import formatting.Cursor;
import glyph.*;
import window.Window;

abstract class AbstractLabel extends Embellishment {
    public AbstractLabel(Window window) {
        super(window);
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        return null;
    }
}
