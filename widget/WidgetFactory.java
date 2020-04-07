package widget;

import glyph.Glyph;
import window.*;

/** Abstract Factory in the Abstract Factory Pattern (87)
 *  Singleton in Singleton pattern (127)
 */

public abstract class WidgetFactory {
    private static WidgetFactory instance = null;

    public static WidgetFactory getInstance() throws Exception {
        if(instance == null) {
            if (System.getenv("LEXILOOK").equals("Green")) {
                instance = GreenFactory.getInstance();
                return instance;
            } else if (System.getenv("LEXILOOK").equals("Red")) {
                instance = RedFactory.getInstance();
                return instance;
            } else {
                throw new Exception("Look and Feel environment Variable doesn't match a known option.");
            }
        }
        return instance;
    }
    public abstract AbstractButton createButton(Window window, Glyph child);
    public abstract AbstractLabel createLabel(Window window, Glyph child);
}
