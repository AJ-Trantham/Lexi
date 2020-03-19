package widget;
import formatting.Cursor;
import glyph.*;
import window.Window;

public abstract class AbstractLabel extends Embellishment {
    public AbstractLabel(Window window) {
        super(window);
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateWidth(child.getBounds().getWidth());
        curs.updateHeight(child.getBounds().getHeight());
        return curs;
    }
}
