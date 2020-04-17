package widget;
import command.Command;
import window.*;
import glyph.Glyph;

/**
 * ConcreteCreator in Factory Method pattern (107)
 * Product in Abstract Factory (87)
 */

public class RedButton extends AbstractButton {

    public RedButton(Window window, Glyph child) {
        super(window, child);
    }

    public RedButton(Window window, Glyph child, Command cmd) {
        super(window, child, cmd);
    }

    @ Override
    public void draw(Window window) {
        window.drawButton(bounds.getX(),bounds.getY(),bounds.getWidth(), bounds.getHeight() , "red");
        super.draw(window);
    }
}
