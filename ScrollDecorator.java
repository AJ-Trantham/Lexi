import java.util.ArrayList;

/** Concrete Decorator in the Decorator Pattern (175) */
public class ScrollDecorator extends Embellishment {

    public ScrollDecorator(Window window) {
        formatter = new SimpleCompositor(window);
        children = new ArrayList<>();
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
