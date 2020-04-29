package glyph;
import analysis.GlyphVisitor;
import window.*;

/** Represents a glyph.Rectangle glyph.Glyph.
 * Composite Pattern (163): Leaf
 * Visitor(331): ConcreteElement
 */
public class Rectangle extends Glyph {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        bounds.setWidth(width);
        bounds.setHeight(height);
        this.width=width;
        this.height=height;
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(this.getBounds().getX(), this.getBounds().getY(), width, height);
    }

    @Override
    public void accept(GlyphVisitor v) {
        v.visit(this);
    }
}
