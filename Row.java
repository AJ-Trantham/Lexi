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

    @Override
    void insert(Glyph glyph, int position) throws OperationNotSupported {
        glyph.parentComposition = this;
        children.add(position, glyph);
        Composition comp = this.getRootGlyph(this);
        formatter.setComposition((comp));
        formatter.format();
    }

    // sets the composition to this row and then calls the compositors compose to begin formatting.
    public void compose() {
        formatter.setComposition(this);
        super.compose();
    }
}
