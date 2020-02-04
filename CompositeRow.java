import java.awt.*;
import java.util.ArrayList;

public class CompositeRow extends Glyph {
    private Glyph parent;
    private Point location;
    private ArrayList<Glyph> children;

    public CompositeRow() {
        parent=null;
        children = new ArrayList<Glyph>();
    }
    @Override
    void draw(Window window) {
        // may need to pass along some coordinate information here too?
        for (Glyph g : children) {
            g.draw(window);
        }
    }

    @Override
    boolean intersects(Point point) {
        return false;
    }

    @Override
    Rect getBounds(Glyph glyph) {
        return null;
    }

    @Override
    void insert(Glyph glyph, int position) throws PenguineException {
        children.add(position,glyph);
    }

    @Override
    void remove(Glyph glyph) throws PenguineException {
        children.remove(glyph);
    }

    @Override
    Glyph getChild(int position) throws PenguineException {
        return children.get(position);
    }

    @Override
    Glyph getParent() {
        return parent;
    }
}
