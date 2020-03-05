package glyph;
import exceptions.OperationNotSupported;
import window.*;
import formatting.*;

/** Concrete Decorator in the Decorator Pattern (175) */
public class ScrollDecorator extends Embellishment {
    private final int scrollWidth = 12;

    public ScrollDecorator(Window window) {
        super(window);
    }

    public void draw(Window win) {
        win.addScrollBar(bounds.getX() + bounds.getWidth() - scrollWidth, bounds.getY(), scrollWidth, bounds.getHeight());
        // draws the child
        try {this.getChild(0).draw(win); } catch (OperationNotSupported ignored) {}
    }

    public void compose() {
        super.compose();
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateWidth( child.bounds.getWidth() + scrollWidth);
        curs.updateHeight(child.bounds.getHeight());
        return curs;
    }
}
