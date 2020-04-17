package widget;
import command.Command;
import glyph.*;
import window.*;
/**
 * Concrete Factory in Abstract Factory pattern (87)
 * Creator in the Factory Method Pattern (107)
 */

public class GreenFactory extends WidgetFactory {
    private static WidgetFactory instance;

    private GreenFactory() {
        super();
    }

    public static WidgetFactory getInstance() {
        if (instance == null) {
            instance = new GreenFactory();
        }
        return instance;
    }

    @Override
    public AbstractButton createButton(Window window, Glyph child) {
        return new GreenButton(window, child);
    }

    @Override
    public AbstractButton createButton(Window window, Glyph child, Command cmd) {
        return new GreenButton(window, child, cmd);
    }

    @Override
    public AbstractLabel createLabel(Window window, Glyph child) { return new GreenLabel(window, child); }

    public String toString() {
        return "Green Factory";
    }
}
