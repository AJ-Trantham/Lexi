/**
 * This is a specific Formatter (Compositor) which is
 */
public class SimpleCompositor implements Formatter {
    //private Composition composition;
    private Composition composition;
    private int height; // Composition should probably know how tall it is????
    private Window window;
    // either store or accept a passed reference of the window objects?

    SimpleCompositor(Window window) {
        this.window = window;
    }

    public void setComposition(Composition composition) { // takes a Composition object which contains all the glyphs that need formatting
        this.composition = composition;
    }

    @Override
    public void format() {
        // will need to store the height of the tallest child to set the height of the parent
        // written from the perspective of a compositor, parent is the current glyph
        // create cursor based on parent - parents's bound object know's where it is
        Composition parent = composition;
        Cursor curs = new Cursor(parent.bounds.getX(), parent.bounds.getY());
        // for each child
        System.out.println("Starting formatting with with: " + parent.getChildren().size() + " children");
        for (Glyph child : parent.getChildren()) {
            // ask (leaf) child to set size, based on window // - this only happens for the leaves that donlt already know theri w & h aka just character
            try { child.setSize(window); } catch (PenguineException ignored) {}
            // ask child to set position, based on cursor
            child.bounds.setX(curs.getX());
            child.bounds.setY(curs.getY());
            // ask child to compose itself, recursively - this only happens for non-leaves
            try { child.compose(); } catch (PenguineException ignored) {}
            // ask parent to adjust itself and cursor, based on child
            // if this child is taller than the previous child, set the parents height to the child's height.
            curs = parent.adjustCursor(curs, child);
            System.out.println("x: " + curs.getX());
            System.out.println("y: " + curs.getY());
            System.out.println("w: " + curs.getWidth());
            System.out.println("h: " + curs.getHeight());
            System.out.println();
        }
        // ask parent to adjust itself, based on cursor
        parent.bounds.setHeight(curs.getHeight());
        parent.bounds.setWidth(curs.getWidth());
        System.out.println("\n" + "Parent's w: " + parent.bounds.getWidth());
        System.out.println("\n" + "Parent's h: " + parent.bounds.getHeight());
    }
}
