package widget;
import formatting.Cursor;
import glyph.*;
import window.Window;

// abstract product in Abstract Factory Pattern
public abstract class AbstractButton extends Embellishment {
    private final int buttonPadding = 2;

    public AbstractButton(Window window) {
        super(window);
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateWidth( child.getBounds().getWidth() + buttonPadding);
        curs.updateHeight(child.getBounds().getHeight() + buttonPadding);
        return curs;
    }
}
