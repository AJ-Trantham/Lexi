package glyph;
import exceptions.OperationNotSupported;
import iterators.ArrayListIterator;
import window.*;
import iterators.*;
import java.util.ArrayList;

/**
 * Composite (163): Composite - A Glyph with children which are glyphs
 * Iterator (257): ConcreteAggregate
 */
public class CompositeGlyph extends Glyph {

    ArrayList<Glyph> children;

    CompositeGlyph() {
        children = new ArrayList<>();
    }

    @Override
    public void draw(Window window) {
        for (Glyph g : children) {
            g.draw(window);
        }
    }

    @Override
    public void remove(Glyph glyph) throws OperationNotSupported {
        children.remove(glyph);
    }

    @Override
    public Glyph find(int x, int y) {
        for (Glyph g: children) {
            if(g.intersects(x,y)) {
                return g.find(x,y);
            }
        }
        return null;
    }

    @Override
    public void insert(Glyph glyph, int position) throws OperationNotSupported {
        glyph.parent = this;
        children.add(position, glyph);
    }

    @Override
    public Iterator createIterator() {
        return new ArrayListIterator<Glyph>(children);
    }

    /**Returns whether the glyph is the last child glyph in the composite */
    public boolean isLast(Glyph child) {
        return child.equals(children.get(children.size()-1));
    }
}
