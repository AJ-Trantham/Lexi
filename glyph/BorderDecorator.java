package glyph;
import formatting.*;
import window.*;
import java.util.ArrayList;

/** Concrete Decorator in the Decorator Pattern (175) */
public class BorderDecorator extends Embellishment {
    private int borderWidth;

    public BorderDecorator(Window window, int borderWidth) {
        formatter = new SimpleCompositor(window);
        children = new ArrayList<>();
        this.borderWidth=borderWidth;
    }

    @Override
    public void draw(Window window) {
        // need to draw the boarder and its one child
        Bounds b = this.bounds;
        window.addBorder(b.getX(), b.getY(), b.getX() + b.getWidth(), b.getY() + b.getHeight(), borderWidth);
        children.get(0).draw(window);
    }

    @Override
    public void compose() {
        // temporarily reset the location to the inside corner so the child draws at the correct place
        this.bounds.setX(this.bounds.getX() + borderWidth);
        this.bounds.setY(this.bounds.getY() + borderWidth);
        super.compose();
        this.bounds.setX(this.bounds.getX() - borderWidth);
        this.bounds.setY(this.bounds.getY() - borderWidth);
    }


    @Override
    public Cursor adjustCursor(Cursor curs, Glyph child) {
        int borderAddition = 2*borderWidth;
        curs.updateHeight(child.bounds.getHeight() + borderAddition);
        curs.updateWidth(child.bounds.getWidth() + borderAddition);

//        System.out.println("Border Formatting.Cursor: ");
//        System.out.println("W: " + curs.getWidth());
//        System.out.println("Height: " + curs.getHeight());
//        System.out.println();

        return curs;
    }
}
