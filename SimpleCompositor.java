/**
 * A concrete Formatter (Compositor or Strategy) implementation in Strategy (315)
 */
public class SimpleCompositor implements Formatter {
    private Composition composition;
    private Window window;

    SimpleCompositor(Window window) {
        this.window = window;
    }

    @Override
    public void setComposition(Composition composition) { // takes a Composition object which contains all the glyphs that need formatting
        this.composition = composition;
    }

    @Override
    public void format() {
        // create cursor based on parent - parents's bound object know's where it is
        Composition parent = composition; // this is the current glyph who is getting formatted
        Cursor curs = new Cursor(parent.bounds.getX(), parent.bounds.getY());
        for (Glyph child : parent.getChildren()) {
            // ask (leaf) child to set size, based on window // - this only happens for the leaves that don't already know their w & h so just character currently
            try { child.setSize(window); } catch (OperationNotSupported ignored) {}
            // ask child to set position, based on cursor
            child.bounds.setX(curs.getX());
            child.bounds.setY(curs.getY());
            // ask child to compose itself, recursively - this only happens for non-leaves
            try { child.compose(); } catch (OperationNotSupported ignored) {}
            // ask parent to adjust itself and cursor, based on child
            curs = parent.adjustCursor(curs, child);
        }
        // ask parent to adjust itself, based on cursor
        parent.bounds.setHeight(curs.getHeight());
        parent.bounds.setWidth(curs.getWidth());
    }
}
