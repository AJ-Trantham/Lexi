package widget;

import glyph.Glyph;
import window.Window;

/**
 * ConcreteCreator in Factory Method pattern (107)
 * Product in Abstract Factory (87)
 */

public class GreenButton extends AbstractButton {

    public GreenButton(Window window, Glyph child) {
        super(window, child);
    }

    public void draw(Window window) {
        window.drawButton(bounds.getX(),bounds.getY(),bounds.getWidth(), bounds.getHeight() , "green");
        super.draw(window);
    }
}
