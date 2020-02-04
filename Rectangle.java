import java.awt.*;

public class Rectangle extends Glyph {
    private Point point1; // upper left point
    private Point point2; // lower right point
    private Glyph parent;
    private int x;
    private int y;
    private int width;
    private int height;

    // could also make this take 2 points and then calculate the width/height
    public Rectangle(int x, int y, int width, int height) {
        this.x=x;
        this.y=y;
        this.point1=new Point(x,y);
        this.width=width;
        this.height=height;
        this.point2=new Point(x+width,y+height);
    }

    @Override
    void draw(Window window) {
        window.drawRectangle(x, y, width, height);
    }

    @Override
    boolean intersects(Point point) {
        //return point.getLocation()    point1.getLocation() && point.getLocation()
        // can I use getLocation to compare point objects
        return (point.x >= point1.x && point.x <= point2.x && point.y >= point1.y && point.y <= point2.y);
    }

    @Override
    Rect getBounds(Glyph glyph) {
        return new Rect(point1, point2);
    }

    @Override
    Glyph getParent() {
        return parent;
    }
}
