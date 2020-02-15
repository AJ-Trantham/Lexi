import java.awt.*;
import java.awt.geom.Point2D;
//import java.awt.geom.Point2D; could maybe use this Point, there are a few different options to explore here
// TODO: make sure and add add a description of classes: 1) patterns they participate in and 2) what the participants are, as the textbook would call them
/**
 * The Glyph interface represents the type of object that can be displayed by Lexi.
 * This Interface is also employs the Composite pattern(163), a structural pattern where objects
 * (Glyphs in our case) are composed into recursive tree structures to represent part-whole hierarchies.
 * Default behavior is to throw an exception since leaf Glyph are more common and will not contain children.
 */
abstract class Glyph {

    protected Glyph parent = null;
    protected Bounds bounds = new Bounds(0,0,0,0); // every glyph will have a bounds object that is 0 when created

    /** Each Glyph needs to know how to draw its self */
    abstract void draw(Window window);

    /** Returns true when the point passed is contained within the bounds of the Glyph
     *  Don't glyphs need to know where they are drawn to see if a point intersects?
     */
    boolean intersects(Point point) {
     return false;
    }

    /** Returns the space a Glyph occupies, returns the opposite corners of the smallest rectangle*/
    Bounds getBounds(Glyph glyph) {
        return bounds;
    }


    /** Adds a child Glyph to this Glyph. */
    void insert(Glyph glyph, int position) throws PenguineException { // could give it an index?
        throw new PenguineException();
    }

    /** Removes a child from the Glyph */
    void remove(Glyph glyph) throws PenguineException {
        throw new PenguineException();
    }

    /** Accesses a child glyph */
    Glyph getChild(int position) throws PenguineException {
        throw new PenguineException();
    }

    /** Returns a reference to a glyph's parent */
    Glyph getParent() {
        return parent;
    }

    // this lets mw avoid casting but is basically the same thing
    Composition getParentComposition() { return (Composition) parent; }

    /** Traverse to root Glyph which is the Document column, used for reformatting */
    protected Composition getRootGlyph(Composition glyph) {
        while(glyph.getParent() != null) {
            glyph = glyph.getParentComposition();
        }
        return glyph;
    }

    void compose() throws PenguineException {
        throw new PenguineException();
    }

    /** Used for formatting, only need to override for Character Glyphs at this point since that is the one that is dynamic in size, maybe add for rectangle later??? */
    void setSize(Window window) throws PenguineException {
        throw new PenguineException();
    };
}
