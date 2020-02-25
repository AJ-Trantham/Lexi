import java.util.ArrayList;

/** Concrete Decorator in the Decorator Pattern (175) */
public class BorderDecorator extends Embellishment {
    private int borderWidth;

    public BorderDecorator(Window window, int borderWidth) {
        formatter = new SimpleCompositor(window);
        children = new ArrayList<>();
        this.borderWidth=borderWidth;
    }

    @Override
    void draw(Window window) {
        // need to draw the boarder and its one child
        Bounds b = this.bounds;
        window.addBorder(b.getX(), b.getY(), b.getX() + b.getWidth(), b.getY() + b.getHeight(), borderWidth);
        children.get(0).draw(window);
    }


    @Override
    Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateHeight(curs.getY() + child.bounds.getHeight());
        curs.updateY(curs.getHeight());
        curs.updateWidth(curs.getWidth() + child.bounds.getWidth());
        curs.updateX(curs.getWidth());
        return curs;
    }
}
