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
        glyph.parent = this;
        //don't want to add more than one child to an embellishment - this is not the most reusable but is clear
        if (children.size() > 1) { throw new OperationNotSupported(); }
        children.add(position, glyph);
        // We need to reformat every time we insert
        Glyph doc = glyph.getRootGlyph();
        doc.compose();
    }

    // may need its own compose method here? TODO: call the parent's compose method?
}
