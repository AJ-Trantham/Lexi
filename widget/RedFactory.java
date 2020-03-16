package widget;

import window.Window;

public class RedFactory extends WidgetFactory {

    @Override
    public AbstractButton createButton(Window window) {
        return new RedButton(window);
    }

    @Override
    public AbstractLabel createLabel(Window window) {
        return new RedLabel(window);
    }
}
