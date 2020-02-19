/** Represents the rectangular area a Glyph occupies and the opposite corners of that rectangular area */
public class Bounds {
    private int x;
    private int y;
    private int height;
    private int width;

    public Bounds(int x, int y, int width, int height) {
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() { return height; }

    public int getWidth() {
        return width;
    }

    public void setX(int x) { this.x = x; }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
