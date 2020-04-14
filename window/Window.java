package window;

import glyph.Glyph;

/** Abstract Factory in the Abstract Factory Pattern (87)
 *  Singleton in Singleton pattern (127)
 *  Abstraction (left side) in Bridge(151)
 *  Note: We can have multiple Window objects but we only want 1 window factory,
 *  similar to how we only wanted one look and feel
 */
public abstract class Window {
    private Glyph glyphToDraw;
    private WindowImp windowImp;

    public Window(String title) {

        try {
            // get a factory and use it to create a window implementation
            WindowSystemFactory wsf = WindowSystemFactory.getWindowSystemFactory();
            windowImp = wsf.createWindowImp(this, title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement window methods, but delegate to the Imp Class
    public void drawCharacter(char c, int x, int y) {
        windowImp.drawCharacter(c, x, y);
    }

    public void drawRectangle(int x, int y, int width, int height) {
        windowImp.drawRectangle(x,y,width,height);
    }

    public int charWidth(char c) {
        return windowImp.charWidth(c);
    }

    public int charHeight(char c) {
        return windowImp.charHeight(c);
    }

    public void setContents(Glyph glyph) {
        this.glyphToDraw = glyph;
        windowImp.setContents();
    }

    public void addBorder(int x1, int y1, int x2, int y2, int width) {
        windowImp.addBorder(x1, y1, x2, y2, width);
    }

    public void addScrollBar(int x, int y, int width, int height) {
        windowImp.addScrollBar(x, y, width, height);
    }

    public void drawButton(int x, int y, int width, int height, String color) {
        windowImp.drawButton(x, y, width, height, color);
    }

    public void drawLabel(int x, int y, int width, int height, String color) {
        windowImp.drawLabel(x, y, width, height, color);
    }

    /**
     * Start a drawing cycle on this window.
     * It is important that the glyph does the drawing, as the windowing system shouldn't know about glyphs
     */
    public void draw() {
        glyphToDraw.draw(this);
    }
}
