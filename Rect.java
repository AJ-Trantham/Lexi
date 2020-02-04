import java.awt.*;
/** Represents the rectangular area a Glyph occupies and the opposite corners of that rectangular area.
 *  The return type of the inserts method for Glyphs.
 * */
public class Rect {
    // do I need this class? Should this be an interface? Would this be a good way to represent the amount
    // of space a Glyph takes up.
    private Point point1;
    private Point point2;

    public Rect(Point pt1, Point pt2) {
        point1=pt1;
        point2=pt2;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }
}
