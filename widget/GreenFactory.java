package widget;
import window.Window;
import glyph.*;
/**
 * Concrete Factory in Abstract Factory pattern (87)
 * Creator in the Factory Method Pattern (107)
 */

public class GreenFactory extends WidgetFactory {
    @Override
    public AbstractButton createButton(Window window, Glyph child) {
        return new GreenButton(window, child);
    }

    @Override
    public AbstractLabel createLabel(Window window, Glyph child) { return new GreenLabel(window, child); }

    public String toString() {
        return "Green Factory";
    }
}
