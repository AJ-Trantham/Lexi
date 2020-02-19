/** Represents a character glyph. This is a leaf Glyph. */
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
    public void setSize(Window window) {
        bounds.setWidth(window.charWidth(c));
        bounds.setHeight(window.charHeight(c));
    }
}
