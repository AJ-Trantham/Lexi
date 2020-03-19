package widget;

import window.*;

// Is the abstract Factory in the Abstract Factory Pattern
public abstract class WidgetFactory {
    private static WidgetFactory instance = null;

    public static WidgetFactory getInstance() throws Exception {
        if(instance == null) {
            if (System.getenv("LexiLook").equals("Green")) {
                instance = new GreenFactory();
                return instance;
            } else if (System.getenv("LexiLook").equals("Red")) {
                instance = new RedFactory();
                return instance;
            } else {
                throw new Exception("Look and Feel environment Variable doesn't match a known option.");
            }
        }
        return instance;
    }
    public abstract AbstractButton createButton(Window window);
    public abstract AbstractLabel createLabel(Window window);
}
