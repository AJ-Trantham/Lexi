/** Is a Composite in the COmposite Patter (163)
 *  Is a Decorator in the Decorator Pattern (175) */
abstract class Embellishment extends Composition {

    @Override
    void insert(Glyph glyph, int position) throws OperationNotSupported {
        glyph.parent = this;
        //don't want to add more than one child to an embellishment - this is not the most reusable but is clear
        if (children.size() > 1) { throw new OperationNotSupported(); }
        children.add(position, glyph);
        // We need to reformat every time we insert
        Glyph doc = glyph.getRootGlyph();
        doc.compose();
    }
}
