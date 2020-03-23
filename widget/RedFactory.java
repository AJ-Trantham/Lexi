package widget;

import glyph.Glyph;
import window.Window;

/**
 * Concrete Factory in Abstract Factory pattern (87)
 * Creator in the Factory Method Pattern (107)
 */

public class RedFactory extends WidgetFactory {

    @Override
    public AbstractButton createButton(Window window, Glyph child) {
        return new RedButton(window, child);
    }

    @Override
    public AbstractLabel createLabel(Window window, Glyph child) {
        return new RedLabel(window, child);
    }
}
