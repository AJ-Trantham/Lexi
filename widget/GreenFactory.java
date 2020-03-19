package widget;

import window.Window;

public class GreenFactory extends WidgetFactory {
    @Override
    public AbstractButton createButton(Window window) {
        return new GreenButton(window);
    }

    @Override
    public AbstractLabel createLabel(Window window) { return new GreenLabel(window); }

    public String toString() {
        return "Green Factory";
    }
}
