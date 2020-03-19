package glyph;
import exceptions.OperationNotSupported;
import formatting.*;
import window.*;

/**  Holds the Formatter object and inherits from composite glyph.
 * Serves as glyph.Composition/Context in Strategy Pattern (315)
 * Component in the Decorator Pattern (175)
 */
public abstract class Composition extends CompositeGlyph {
    protected Formatter formatter;

    public Composition(Window window) {
        formatter = new SimpleCompositor(window);
    }

    public void compose() {
        formatter.setComposition(this);
        //System.out.println("Starting Formatting.");
        formatter.format();
    }

    @Override
    /** We need to reformat every time we insert
     *  lets CompositeGlyph do the inserting and Composition
     *  do the formatting */
    public void insert(Glyph glyph, int pos) throws OperationNotSupported {
        super.insert(glyph, pos);
        beginFormat(glyph);
    }

    @Override
    public void remove(Glyph glyph) throws OperationNotSupported{
        super.remove(glyph);
        beginFormat(glyph);
    }

    /** rows and cols override, updates the height/width of cursor
     *  this is different for each subclass
     */
    public abstract Cursor adjustCursor(Cursor curs, Glyph child);

    private void beginFormat(Glyph glyph) throws OperationNotSupported{
        Glyph doc = glyph.getRootGlyph();
        doc.compose();
    }
}
