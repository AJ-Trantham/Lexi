package glyph;
import formatting.*;
import java.util.ArrayList;
import window.*;

/** glyph.Column is a subclass of glyph.CompositeGlyph
 * Composite in Composite Pattern (163) */

public class Column extends Composition {

    public Column(Window window) {
        formatter = new SimpleCompositor(window);
        children = new ArrayList<>();
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateHeight(curs.getY() + child.bounds.getHeight());
        curs.updateY(curs.getHeight());
        // TODO: NEED TO RE-TEST COLUMN FUNCTIONALITY, AS I REMOVED child.bounds.getX() + ... from line 17
        if (curs.getWidth() < child.bounds.getWidth()) { curs.updateWidth(child.bounds.getWidth());}
        return curs;
    }
}
