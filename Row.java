/** Row is a subclass of CompositeGlyph in Composite Pattern (163) */
import java.util.ArrayList;

public class Row extends Composition {

   public Row(Window window) {
       formatter = new SimpleCompositor(window);
       children = new ArrayList<>();
    }

    @Override
    Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateX(child.bounds.getX() + child.bounds.getWidth());
        curs.updateWidth(curs.getWidth() + child.bounds.getWidth());
        if (child.bounds.getHeight() > curs.getHeight()) {
            curs.updateHeight(child.bounds.getHeight());
        }
        return curs;
    }
}
