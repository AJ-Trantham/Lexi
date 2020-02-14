public class Rectangle extends Glyph {
    // has a bounds object
    private int width;
    private int height;

    // could also make this take 2 points and then calculate the width/height
    public Rectangle(int width, int height) {
        bounds.setWidth(width);
        bounds.setHeight(height);
        // these could be unecessary since that info is stored in the bounds object, but it makes sense for a Rectangle to know its width/height
        // might make sense to store this if we wanted to add margin between glyphs, this way a rectangles width would be different that its bounds width for example
        this.width=width;
        this.height=height;
    }

    @Override
    void setSize(Window window) throws PenguineException {

    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(this.getBounds(this).getX(), this.getBounds(this).getY(), width, height);
    }
}
