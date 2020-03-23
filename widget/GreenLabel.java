package widget;

import formatting.Cursor;
import glyph.Glyph;
import window.Window;

/**
 * ConcreteCreator in Factory Method pattern (107)
 * Product in Abstract Factory (87)
 */

public class GreenLabel extends AbstractLabel {
    public GreenLabel(Window window, Glyph child) {
        super(window, child);
    }

    @Override
    public void draw(Window window) {
        window.drawLabel(bounds.getX(),bounds.getY(),bounds.getWidth(), bounds.getHeight() , "green");
        super.draw(window);
    }
}
