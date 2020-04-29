package glyph;
import analysis.GlyphVisitor;
import exceptions.OperationNotSupported;
import window.*;
import formatting.*;
/** glyph.Row is a subclass of glyph.CompositeGlyph
 *  Composite in Composite Pattern (163)
 *  Visitor(331): ConcreteElement
 */
public class Row extends Composition {

   public Row(Window window) {
       super(window);
   }

   public Row(Window window, String string) {
       super(window);
       try {
            for (int i=0; i<string.length(); i++)
                insert(new Character(string.charAt(i)),i);
       } catch (OperationNotSupported e) {
           System.out.println(e);
       }
    }

    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateX(child.bounds.getX() + child.bounds.getWidth());
        curs.updateWidth(curs.getWidth() + child.bounds.getWidth());
        if (child.bounds.getHeight() > curs.getHeight()) {
            curs.updateHeight(child.bounds.getHeight());
        }
        return curs;
    }

    @Override
    public void accept(GlyphVisitor v) {
        v.visit(this);
    }
}
