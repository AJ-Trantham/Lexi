/** A Glyph with children which are also glyphs. Serves as Composite in the Composite Pattern (163) */

import java.util.ArrayList;

public class CompositeGlyph extends Glyph {

    protected ArrayList<Glyph> children;

    @Override
    void draw(Window window) {
        for (Glyph g : children) {
            g.draw(window);
        }
    }

    @Override
    void remove(Glyph glyph) throws OperationNotSupported {
        children.remove(glyph);
    }

    @Override
    Glyph getChild(int position) throws OperationNotSupported {
        return children.get(position);
    }

    @Override
    void insert(Glyph glyph, int position) throws OperationNotSupported {
        glyph.parent = this;
        children.add(position, glyph);
        // We need to reformat every time we insert
        Glyph doc = glyph.getRootGlyph();
        doc.compose();
    }

    /** Used by a Formatter implementation */
    public ArrayList<Glyph> getChildren() {
        return children;
    }
}
