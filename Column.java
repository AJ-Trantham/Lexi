/** Column is a subclass of CompositeGlyph in Composite Pattern (163) */
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

    // sets the composition to this column and then calls the compositors compose to begin formatting.
    public void compose() {
        formatter.setComposition(this);
        super.compose();
    }

    @Override
    void insert(Glyph glyph, int position) throws OperationNotSupported {
        glyph.parentComposition = this;
        children.add(position, glyph);
        Composition comp = this.getRootGlyph(this);
        formatter.setComposition((comp));
        formatter.format();
    }

}
