package analysis;

import glyph.*;
import glyph.Character;
/**Visitor(331): visitor */
public interface GlyphVisitor {

    void visit(Glyph e);
    void visit(Character e);
    void visit(Rectangle e);
    void visit(Row e);
    void visit(Column e);
    void visit(Embellishment e);
}
