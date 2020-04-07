package glyph;
import exceptions.*;
import window.*;


/** Is a Composite in the Composite Patter (163)
 *  Is a Composition - Context in Strategy Pattern
 *  Is a Decorator in the Decorator Pattern (175) */
public abstract class Embellishment extends Composition {
    public Embellishment(Window window, Glyph child) {
        super(window);
        try {
            super.insert(child,0);
        } catch (OperationNotSupported operationNotSupported) {
            operationNotSupported.printStackTrace();
        }
    }

    @Override
    public void insert(Glyph glyph, int position) throws OperationNotSupported {
        this.getChild(0).insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) throws OperationNotSupported {
        this.getChild(0).remove(glyph);
    }
}
