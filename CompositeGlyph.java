import java.awt.*;
import java.util.ArrayList;

public class CompositeGlyph extends Glyph {

    protected ArrayList<Glyph> children;

    @Override
    boolean intersects(Point point) {
        return super.intersects(point);
    }

    @Override
    void draw(Window window) {
        for (Glyph g : children) {
            g.draw(window);
        }
    }
    @Override
    void insert(Glyph glyph, int position) throws PenguineException {
        children.add(position, glyph);
        // will need to reformat here
        // get root and pass it to reformat? k
    }

    @Override
    void remove(Glyph glyph) throws PenguineException {
        children.remove(glyph);
    }

    @Override
    Glyph getChild(int position) throws PenguineException {
        return children.get(position);
    }
}
