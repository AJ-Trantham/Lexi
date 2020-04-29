package glyph;
import analysis.*;
import command.*;
import exceptions.*;
import iterators.*;
import window.*;

/**
 * Patterns Employed:
 *  Composite (163): Component
 *  Chain of Responsibility (223): Handler - find() serves as handle request
 *  Iterator (257): Aggregate
 *  Visitor (332): Element - accept(GlyphVisitor v)
 * Represents the type of object that can be displayed by Lexi.
 * Default behavior is to throw an exception since leaf glyph.Glyph are more common and will not contain children.

 */
public abstract class Glyph implements IteratorNode<Glyph> {
    protected Glyph parent = null;
    protected Bounds bounds = new Bounds(0,0,0,0); // each glyph needs a bounds object, to store location
    protected Command command = null;
    protected Iterator iterator = null;

    /** Each glyph.Glyph needs to know how to draw its self */
    public abstract void draw(Window window);

    /** Returns true when the point passed is contained within the bounds of the glyph.Glyph */
    //    ____
    //   |*   |
    //   |____|
    public boolean intersects(int x, int y) {
        return (x >= bounds.getX()) && x <= (bounds.getX() + bounds.getWidth())
                && y >= bounds.getY() && y <= (bounds.getY() + bounds.getHeight());
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

    /** Returns a glyphs command. Default: throws Exception, not all glyph have a command. */
    public Command click() throws OperationNotSupported {
        throw new OperationNotSupported();
    }

    /** Sets the Command */
    public void setCommand(Command cmd) {
        command = cmd;
    }

    /** Returns the Glyph which occupies the given coordinates
     *  Glyph either returns itself or passes it along.
     *  HandleRequest in pattern
     */
    public Glyph find(int x, int y) {
        return null;
    }

    /** Returns an iterator for a glyph, underlying FactoryMethod for Factory embedded in the Iterator Pattern.
     *  Default operation is to return a NullIterator for leaves.
     *  Intended to be overridden by non-leave glyphs.
     */
    public Iterator<Glyph> createIterator() {
        return new NullIterator<Glyph>();
    }

    /**Each GLyph class needs to define this.
     * Yes duplicate code, but it gives us differentiation
     * amongst glyphs. */
    public void accept(GlyphVisitor v) {
        v.visit(this);
    }

    public boolean isLast(Glyph child) {
        return false;
    }
}
