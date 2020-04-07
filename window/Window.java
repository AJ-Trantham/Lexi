package window;

import glyph.Glyph;

/** Abstract Factory in the Abstract Factory Pattern (87)
 *  Singleton in Singleton pattern (127)
 *  Note: We can have multiple Window objects but we only want 1 window factory,
 *  similar to how we only wanted one look and feel
 */
public abstract class Window {
    protected static WindowImp windowImp;
    protected Glyph glyphToDraw;

//    public Window() {
//        windowImp =
//    }

    public WindowImp getInstance( Window window) {
        if (windowImp == null) {
            //get a swing window implementation
            if (System.getenv("WINDOW").equals("Swing")) {
                windowImp = new SwingWindow(window.getTitle(), window);
            } else if (System.getenv("WINDOW").equals("Awt")) {
                windowImp = new AwtWindow(window.getTitle(), window);
            }
        }
        return windowImp;
    }

    protected abstract String getTitle();

    // Implement window methods
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
        // I can probably just get rid of this parameter, just let the windwoing system do its thing, maybe pass this glyph to draw
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

    public void draw() {
        glyphToDraw.draw(this);
    }
}
