package widget;

import formatting.Cursor;
import glyph.Glyph;
import window.Window;

public class RedLabel extends AbstractLabel {
    public RedLabel(Window window) {
        super(window);
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        return null;
    }
}
