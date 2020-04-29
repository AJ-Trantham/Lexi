package glyph;
import analysis.GlyphVisitor;
import exceptions.*;
import iterators.Iterator;
import window.*;


/** Is a Composite in the Composite Patter (163)
 *  Is a Composition - Context in Strategy Pattern
 *  Is a Decorator in the Decorator Pattern (175)
 *  Visitor(331): ConcreteElement
 */
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
        Iterator i = this.createIterator();
        i.init();
        i.currentItem().insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) throws OperationNotSupported {
        Iterator i = this.createIterator();
        i.init();
        i.currentItem().remove(glyph);
    }

    @Override
    public void accept(GlyphVisitor v) {
        v.visit(this);
    }
}
