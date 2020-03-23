package widget;

import formatting.Cursor;
import glyph.Glyph;
import window.Window;

/**
 * ConcreteCreator in Factory Method pattern (107)
 * Product in Abstract Factory (87)
 */

public class RedLabel extends AbstractLabel {
    public RedLabel(Window window, Glyph child) {
        super(window, child);
    }

    @Override
    public void draw(Window window) {
        window.drawLabel(bounds.getX(),bounds.getY(),bounds.getWidth(), bounds.getHeight() , "red");
        super.draw(window);
    }
}
