/** Column is a subclass of CompositeGlyph
 * Composite in Composite Pattern (163) */
import java.util.ArrayList;

public class Column extends Composition {

    public Column(Window window) {
        formatter = new SimpleCompositor(window);
        children = new ArrayList<>();
    }

    @Override
    Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateHeight(curs.getY() + child.bounds.getHeight());
        curs.updateY(curs.getHeight());
        if (curs.getWidth() < child.bounds.getWidth()) { curs.updateWidth(curs.getWidth() + child.bounds.getWidth());}
        return curs;
    }
}
