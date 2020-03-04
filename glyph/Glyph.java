package glyph;
import exceptions.*;
import window.Window;
import java.awt.*; // TODO: this is for point may want to not include this

/**
 * Represents the type of object that can be displayed by Lexi.
 * glyph.Glyph participates as Component in Composite Pattern (163)
 * Default behavior is to throw an exception since leaf glyph.Glyph are more common and will not contain children.
 */
public abstract class Glyph {
    Glyph parent = null;
    protected Bounds bounds = new Bounds(0,0,0,0); // each glyph needs a bounds object, to store location

    /** Each glyph.Glyph needs to know how to draw its self */
    public abstract void draw(Window window);

    /** Returns true when the point passed is contained within the bounds of the glyph.Glyph */
    //    ____
    //   |*   |
    //   |____|
    boolean intersects(Point point) {
        return (point.getX() >= this.bounds.getX()) && point.getX() <= (this.bounds.getX() + this.bounds.getWidth())
                && point.getY() <= this.bounds.getY() && point.getY() >= (this.bounds.getX() + this.bounds.getHeight());
    }

    /** Returns the space a glyph.Glyph occupies, returns the opposite corners of the smallest rectangle*/
    public Bounds getBounds() {
        return bounds;
    }


    /** Adds a child glyph.Glyph to this glyph.Glyph. */
    public void insert(Glyph glyph, int position) throws OperationNotSupported { // could give it an index?
        throw new OperationNotSupported();
    }

    /** Removes a child from the glyph.Glyph */
    public void remove(Glyph glyph) throws OperationNotSupported {
        throw new OperationNotSupported();
    }

    /** Accesses a child glyph */
    public Glyph getChild(int position) throws OperationNotSupported {
        throw new OperationNotSupported();
    }


    /** Returns a reference to a glyph's parent glyph.Composition - used for formatting */
    private Glyph getParent() {
        return parent;
    }

    /** Traverse to root glyph.Glyph which is the Document column
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
    public void compose() throws OperationNotSupported {
        throw new OperationNotSupported();
    }

    /** Used for formatting, only need to override for glyph.Character Glyphs at this point since that is the one that is dynamic in size, maybe add for rectangle later??? */
    public void setSize(Window window) throws OperationNotSupported {
        throw new OperationNotSupported();
    }
}
