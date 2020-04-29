package formatting;
import glyph.*;
import iterators.Iterator;
import window.*;
import exceptions.*;

/**
 * A concrete Formatting.Formatter (Compositor or Strategy) implementation in Strategy (315)
 */
public class SimpleCompositor implements Formatter {
    private Composition composition;
    private Window window;

    public SimpleCompositor(Window window) {
        this.window = window;
    }

    @Override
    public void setComposition(Composition composition) { // takes a glyph.Composition object which contains all the glyphs that need formatting
        this.composition = composition;
    }

    @Override
    public void format() {
        // create cursor based on parent - parents's bound object know's where it is
        Composition parent = composition; // this is the current glyph who is getting formatted
        //ArrayList<Glyph> children = parent.children;
        Cursor curs = new Cursor(parent.getBounds().getX(), parent.getBounds().getY());

        Glyph child = null;
        Iterator<Glyph> i = parent.createIterator();
        for(i.init(); !i.isDone(); i.next()) {
            child = i.currentItem();
            // ask (leaf) child to set size, based on window // - this only happens for the leaves that don't already know their w & h so just character currently
            try { child.setSize(window); } catch (OperationNotSupported ignored) {}
            // ask child to set position, based on cursor
            child.getBounds().setX(curs.getX());
            child.getBounds().setY(curs.getY());
            // ask child to compose itself, recursively - this only happens for non-leaves
            try { child.compose(); } catch (OperationNotSupported ignored) {}
            // ask parent to adjust itself and cursor, based on child
            curs = parent.adjustCursor(curs, child);
        }

        // ask parent to adjust itself, based on cursor
        parent.getBounds().setHeight(curs.getHeight());
        parent.getBounds().setWidth(curs.getWidth());
    }
}
