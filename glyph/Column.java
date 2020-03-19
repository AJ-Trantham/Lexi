package glyph;
import exceptions.OperationNotSupported;
import formatting.*;
import window.*;

/** glyph.Column is a subclass of glyph.CompositeGlyph
 * Composite in Composite Pattern (163) */

public class Column extends Composition {

    public Column(Window window) {
        super(window);
    }

    public Column(Window window, String[] strings) {
        super(window);
        for (int i=0; i<strings.length; i++) {
            try {
                insert(new Row(window, strings[i]), i);
            } catch (OperationNotSupported operationNotSupported) {
                operationNotSupported.printStackTrace();
            }
        }
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateY(curs.getY() + child.bounds.getHeight());
        curs.updateHeight(child.bounds.getHeight() + curs.getHeight());
        if (curs.getWidth() < child.bounds.getWidth()) { curs.updateWidth(child.bounds.getWidth());}
        return curs;
    }
}
