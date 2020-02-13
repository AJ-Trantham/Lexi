import java.awt.*;

/**
 * Represents a character glyph. This is a leaf Glyph.
 */
public class Character extends Glyph {
    private char c;

    public Character(char c) {
        this.c = c;
    }

    @Override
    void draw(Window window) {
        window.drawCharacter(c, super.getBounds(this).getX(), super.getBounds(this).getY());
    }

    @Override
    // if every Glyph object has a Bounds object then this can be implemented in the parent class
    boolean intersects(Point point) {
        return false;
    }
}
