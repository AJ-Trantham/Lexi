package glyph;
import formatting.*;

/**  Holds the Formatter object and inherits from composite glyph.
 * Serves as glyph.Composition/Context in Strategy Pattern (315) */
public abstract class Composition extends CompositeGlyph {
    protected Formatter formatter;

    public void compose() {
        formatter.setComposition(this);
        formatter.format();
    }

    /** rows and cols override, updates the height/width of cursor - this is different for each subclass */
    public abstract Cursor adjustCursor(Cursor curs, Glyph child);
}
