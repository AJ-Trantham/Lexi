import java.awt.*;
//import java.awt.geom.Point2D; could maybe use this Point, there are a few different options to explore here

/**
 * The Glyph interface represents the type of object that can be displayed by Lexi.
 * This Interface is also employs the Composite pattern(163), a structural pattern where objects
 * (Glyphs in our case) are composed into recursive tree structures to represent part-whole hierarchies.
 * Default behavior is to throw an exception since leaf Glyph are more common and will not contain children.
 */
abstract class Glyph {

    /** Each Glyph needs to know how to draw its self */
    abstract void draw(Window window);

    /** Returns true when the point passed is contained within the bounds of the Glyph
     *  Don't glyphs need to know where they are drawn to see if a point intersects?
     */
    abstract boolean intersects(Point point); //could probably implement this here, depend if all glyphs know their location

    /** Returns the space a Glyph occupies, returns the opposite corners of the smallest rectangle*/
    abstract Rect getBounds(Glyph glyph);
        //implement here or lower??

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
    abstract Glyph getParent();
}
