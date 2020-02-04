import java.awt.*;

/**
 * Represents a character glyph. This is a leaf Glyph.
 */
public class Character extends Glyph {
    private char c;
    private Glyph parent;
    private Point location;

    public Character(char c) {
        this.c = c;
    }

    @Override
    void draw(Window window) {
        window.drawCharacter(c,0,0);
    }

    @Override
    boolean intersects(Point point) {

        return false;
    }

    @Override
    Rect getBounds(Glyph glyph) {
        return null;
    }

    @Override
    Glyph getParent() {
        return parent;
    }

}
