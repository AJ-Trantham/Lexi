/** contains only the visible glyphs that make up
 the document's basic content Described on pg 42
 Update: this class holds the Formatter object and inherits from composite glyph
 */
public abstract class Composition extends CompositeGlyph{
    protected Formatter formatter;

//    public Composition( Window window) {
//        this.formatter = new SimpleCompositor(window);
//    }
//
//    public Composition() {
//        // this has got to be an issue
//    }

    public void compose() {
        formatter.format();
    }

    // this could have an abstract method that the rows and cols override that updates the height for formatting
    abstract Cursor adjustCursor(Cursor curs, Glyph child);
}
