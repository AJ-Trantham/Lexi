/** contains only the visible glyphs that make up
 the document's basic content Described on pg 42
 Update: this class holds the Formatter object and inherits from composite glyph
 */
public abstract class Composition extends CompositeGlyph{
    private Formatter formatter;

    public Composition() {
        this.formatter = new SimpleCompositor();
    }
}
