/**
 * Represents a Rectangle Glyph. This is a Leaf in the Composite Pattern (163)
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
    void setSize(Window window) throws OperationNotSupported {

    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(this.getBounds(this).getX(), this.getBounds(this).getY(), width, height);
    }
}
