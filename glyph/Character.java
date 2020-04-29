package glyph;

import window.*;
import analysis.*;

/** Represents a character glyph. This is a leaf glyph.Glyph.
 * Leaf in Composite Pattern (163) */
public class Character extends Glyph {
    private char c;

    public Character(char c) {
        this.c = c;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(c, super.getBounds().getX(), super.getBounds().getY());
    }

    @Override
    public void setSize(Window window) {
        bounds.setWidth(window.charWidth(c));
        bounds.setHeight(window.charHeight(c));
    }

    @Override
    public void accept(GlyphVisitor v) { v.visit(this); }

    public char getCharacter() {
        return c;
    }

    public String toString() {
        return "" + c;
    }
}
