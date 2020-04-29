package window;

import command.*;
import exceptions.OperationNotSupported;
import glyph.Glyph;

/** Abstract Factory in the Abstract Factory Pattern (87)
 *  Singleton in Singleton pattern (127)
 *  Abstraction (left side) in Bridge(151)
 *  Command (233): Invoker and Receiver
 *  Note: We can have multiple Window objects but we only want 1 window factory,
 *  similar to how we only wanted one look and feel
 */
public abstract class Window {
    private Glyph root;
    private WindowImp windowImp;
    private KeyMap keyMap;
    private CommandHistory commandHistory;

    public Window(String title) {
        try {
            // get a factory and use it to create a window implementation
            WindowSystemFactory wsf = WindowSystemFactory.getWindowSystemFactory();
            windowImp = wsf.createWindowImp(this, title);
            commandHistory = CommandHistory.getInstance();
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
        this.root = glyph;
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

    public void setFrontSize(int size) {
        windowImp.setFontSize(size);
    }

    public int getFontSize() {
        return windowImp.getFontSize();
    }

    /** Refreshes window content */
    public void repaint() {
        windowImp.repaint();
    }

    /**
     * Start a drawing cycle on this window.
     * It is important that the glyph does the drawing, as the windowing system shouldn't know about glyphs
     */
    public void draw() {
        root.draw(this);
    }

    public void reformat() {
        try { root.compose(); }
        catch (OperationNotSupported ignore) {}
    }

    public void setKeyMap(KeyMap keyMap) {
        this.keyMap = keyMap;
    }

    void key(char keyChar) {
        Command cmd = keyMap.get(keyChar);
        if (cmd != null) {
            cmd.execute(this);
            if (cmd.isUndoable()) {commandHistory.add(cmd);}
        }
    }

    /** Executes the command object of the glyph that was clicked on*/
    void click(int x, int y) {
        Glyph clikedGlyph = root.find(x, y);
        if (clikedGlyph != null) {
            Command cmd = null;
            try {
                cmd = clikedGlyph.click();
                cmd.execute(this);
                if (cmd.isUndoable()) {commandHistory.add(cmd);}
            } catch (OperationNotSupported operationNotSupported) {
                operationNotSupported.printStackTrace();
            }

        }
    }

    public Glyph getRoot() {
        return root;
    }
}
