/** Cursor keeps track of the current position when formatting */

public class Cursor {
    private int x ;
    private int y ;
    private int height;
    private int width;

    public Cursor(int x, int y) {
        this.x=x;
        this.y=y;
        this.width=0;
        this.height=0;
    }

    public void updateX(int newX) {
        x=newX;
    }

    public void updateY(int newY) {
        y=newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updateWidth(int newWidth) { width=newWidth;}

    public void updateHeight(int newHeight) {height=newHeight;}

    public int getWidth() { return width; }

    public int getHeight() { return height; }

}
