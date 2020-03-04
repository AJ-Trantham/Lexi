package glyph;
import exceptions.OperationNotSupported;
import window.*;
/** A glyph.Glyph with children which are also glyphs. Serves as Composite in the Composite Pattern (163) */

import java.util.ArrayList;

public class CompositeGlyph extends Glyph {

    protected ArrayList<Glyph> children;

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
        return children.get(position);
    }

    @Override
    public void insert(Glyph glyph, int position) throws OperationNotSupported {
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
