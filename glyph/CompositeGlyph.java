package glyph;
import exceptions.OperationNotSupported;
import window.*;
import java.util.ArrayList;
/** A glyph.Glyph with children which are also glyphs. Serves as Composite in the Composite Pattern (163) */

public class CompositeGlyph extends Glyph {

    protected ArrayList<Glyph> children;

    public CompositeGlyph() {
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
    public Glyph getChild(int position) throws OperationNotSupported {
        if (position > children.size() -1) { return null; }
        return children.get(position);
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
}
