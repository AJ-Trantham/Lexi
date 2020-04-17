package widget;
import command.Command;
import window.*;
import glyph.Glyph;

/**
 * Concrete Factory in Abstract Factory pattern (87)
 * Creator in the Factory Method Pattern (107)
 */

public class RedFactory extends WidgetFactory {
    private static WidgetFactory instance = null;

    private RedFactory() {
        super();
    }

    public static WidgetFactory getInstance() {
        if (instance == null) {
            instance = new RedFactory();
        }
        return instance;
    }

    @Override
    public AbstractButton createButton(Window window, Glyph child) {
        return new RedButton(window, child);
    }

    @Override
    public AbstractButton createButton(Window window, Glyph child, Command cmd) {
        return new GreenButton(window, child, cmd);
    }

    @Override
    public AbstractLabel createLabel(Window window, Glyph child) {
        return new RedLabel(window, child);
    }
}
