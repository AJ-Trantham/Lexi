package glyph;
import exceptions.OperationNotSupported;
import formatting.*;
import window.*;

/** Concrete Decorator in the Decorator Pattern (175) */
public class BorderDecorator extends Embellishment {
    private int borderWidth;

    public BorderDecorator(Window window, Glyph child, int borderWidth) {
        super(window, child);
        this.borderWidth = borderWidth;
        this.compose();
    }

    @Override
    public void draw(Window window) {
        // need to draw the border and its one child
        Bounds b = this.bounds;
        window.addBorder(b.getX(), b.getY(), b.getX() + b.getWidth(), b.getY() + b.getHeight(), borderWidth);
        children.get(0).draw(window);
    }


    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        int borderAddition = 2*borderWidth;
        curs.updateHeight(child.bounds.getHeight() + borderAddition);
        curs.updateWidth(child.bounds.getWidth() + borderAddition);
        //adjusting child here keeps border functionality in line with strategy pattern
        child.bounds.setX(this.bounds.getX() + borderWidth);
        child.bounds.setY(this.bounds.getY() + borderWidth);
        try {
            child.compose();
        } catch (OperationNotSupported operationNotSupported) {
            operationNotSupported.printStackTrace();
        }
        return curs;
    }
}
