import java.util.ArrayList;

public class Row extends Composition {

   public Row(Window window) {
       formatter = new SimpleCompositor(window);
       children = new ArrayList<Glyph>();
    }

   //public void compose() {
       //System.out.println("Compose in Row format");
   // }

    @Override
    Cursor adjustCursor(Cursor curs, Glyph child) {
        curs.updateX(child.bounds.getX() + child.bounds.getWidth());
        curs.updateWidth(curs.getWidth() + child.bounds.getWidth());
        if (child.bounds.getHeight() > this.bounds.getHeight()) {
            this.bounds.setHeight(child.bounds.getHeight());
            curs.updateHeight(child.bounds.getHeight());
        }
        return curs;
    }

    @Override
    void insert(Glyph glyph, int position) throws PenguineException {
        glyph.parent = this;
        children.add(position, glyph);
        // but probbaly need to send the root parent here to start reformatting
        // this.getRootGlyph(this); // I am not sure about this since the parent is a Glyph but I need it to be a composition in this case.
        formatter.setComposition((this));
        formatter.format();
        // will need to reformat here
        // get root and pass it to reformat? k
    }

    // sets the composition to this row and then calls the compositors compose to begin formatting.
    public void compose() {
        formatter.setComposition(this);
        super.compose();
    }
}
