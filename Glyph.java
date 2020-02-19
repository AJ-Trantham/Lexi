import java.awt.*;
/**
 * The Glyph interface represents the type of object that can be displayed by Lexi.
 * This Interface is also employs the Composite pattern(163), a structural pattern where objects
 * (Glyphs in our case) are composed into recursive tree structures to represent part-whole hierarchies.
 * Glyph is the participates in this pattern as Component
 * Default behavior is to throw an exception since leaf Glyph are more common and will not contain children.
 */
abstract class Glyph {
    protected Glyph parent = null;
    protected Bounds bounds = new Bounds(0,0,0,0); // each glyph needs a bounds object, to store location

    /** Each Glyph needs to know how to draw its self */
    abstract void draw(Window window);

    /** Returns true when the point passed is contained within the bounds of the Glyph */
    //    ____
    //   |*   |
    //   |____|
    boolean intersects(Point point) {
        return (point.getX() >= this.bounds.getX()) && point.getX() <= (this.bounds.getX() + this.bounds.getWidth())
                && point.getY() <= this.bounds.getY() && point.getY() >= (this.bounds.getX() + this.bounds.getHeight());
    }

    /** Returns the space a Glyph occupies, returns the opposite corners of the smallest rectangle*/
    Bounds getBounds(Glyph glyph) {
        return bounds;
    }


    /** Adds a child Glyph to this Glyph. */
    void insert(Glyph glyph, int position) throws OperationNotSupported { // could give it an index?
        throw new OperationNotSupported();
    }

    /** Removes a child from the Glyph */
    void remove(Glyph glyph) throws OperationNotSupported {
        throw new OperationNotSupported();
    }

    /** Accesses a child glyph */
    Glyph getChild(int position) throws OperationNotSupported {
        throw new OperationNotSupported();
    }


    /** Returns a reference to a glyph's parent Composition - used for formatting */
    Glyph getParent() {
        return parent;
    }

    /** Traverse to root Glyph which is the Document column
     *  Returning the composition since that is what is needed for formatting.
     */
    Glyph getRootGlyph() {
        Glyph docRoot = this;
        while(docRoot.getParent() != null) {
             docRoot = docRoot.getParent();
        }
        return docRoot;
    }

    /** Only Glyphs with Children (CompositeGlyphs) are able to Compose themselves */
    void compose() throws OperationNotSupported {
        throw new OperationNotSupported();
    }

    /** Used for formatting, only need to override for Character Glyphs at this point since that is the one that is dynamic in size, maybe add for rectangle later??? */
    void setSize(Window window) throws OperationNotSupported {
        throw new OperationNotSupported();
    }
}
