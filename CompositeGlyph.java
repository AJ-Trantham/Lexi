/** A Glyph with children. Serves as Composite in the Composite Pattern (163) */
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
    void remove(Glyph glyph) throws OperationNotSupported {
        children.remove(glyph);
    }

    @Override
    Glyph getChild(int position) throws OperationNotSupported {
        return children.get(position);
    }

    public ArrayList<Glyph> getChildren() {
        return children;
    }
}
