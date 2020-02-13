/**
 * This is a specific Formatter (Compositor) which is
 */
public class SimpleCompositor implements Formatter {
    private Composition composition;
    // either store or accept a passed reference of the window objects

    @Override
    public void setComposition(Composition composition) { // takes a Composition object which contains all the glyphs that need formatting
        this.composition = composition;
    }

    @Override
    public void compose() {
        // will need to store the height of the tallest child to set the height of the parent
        // written from the perspective of a compositor, parent is the current glyph
        // create cursor based on parent - parents's bound object know's where it is
        //for (... child= ...) {
//        for (Glyph child : composition.getChildren()) {
//            // ask (leaf) child to set size, based on window
//            // ask child to set position, based on cursor
//            // ask child to compose itself, recursively
//            // ask parent to adjust itself and cursor, based on child
//        }
        //}
        // ask parent to adjust itself, based on cursor
    }
}
