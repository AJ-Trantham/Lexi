package glyph;
import window.*;
import formatting.*;

import java.util.ArrayList;

/** Concrete Decorator in the Decorator Pattern (175) */
public class ScrollDecorator extends Embellishment {
    private final int scrollWidth = 12;

    public ScrollDecorator(Window window) {
        formatter = new SimpleCompositor(window);
        children = new ArrayList<>();
    }

    public void draw(Window win) {
        win.addScrollBar(bounds.getX() + bounds.getWidth() - scrollWidth, bounds.getY(), scrollWidth, bounds.getHeight());
        children.get(0).draw(win); // don't forget to draw children
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
