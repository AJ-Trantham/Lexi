package widget;

import window.*;

// Is the abstract Factory in the Abstract Factory Pattern
public abstract class WidgetFactory {
    public static WidgetFactory getInstance() {

        if (System.getenv("LexiLook").equals("Green")) {
                return new GreenFactory();
        } else if (System.getenv("LexiLook").equals("Red")) {
            return new RedFactory();
        }
        return null;
    }
    public abstract AbstractButton createButton(Window window);
    public abstract AbstractLabel createLabel(Window window);
}
