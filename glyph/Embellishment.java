package glyph;
import exceptions.*;
import window.Window;


/** Is a Composite in the Composite Patter (163)
 *  Is a Composition - Context in Strategy Pattern
 *  Is a Decorator in the Decorator Pattern (175) */
abstract class Embellishment extends Composition {

    public Embellishment(Window window) {
        super(window);
    }

    @Override
    public void insert(Glyph glyph, int position) throws OperationNotSupported {
        // only allow a single child
        if (position > 0) {
            throw new OperationNotSupported();
        }
        super.insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) throws OperationNotSupported {
        this.getFirstChild().remove(glyph);
    }
}
