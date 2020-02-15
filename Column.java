import java.util.ArrayList;

public class Column extends Composition {

    public Column(Window window) {
        formatter = new SimpleCompositor(window);
        children = new ArrayList<Glyph>();
    }

    @Override
    Cursor adjustCursor(Cursor curs, Glyph child) {
        //
        curs.updateHeight(curs.getY() + child.bounds.getHeight());
        System.out.println("Curs Height: " + curs.getHeight());
        //curs.updateHeight(this.bounds.getHeight());
        curs.updateY(curs.getHeight());
        if (curs.getWidth() < child.bounds.getWidth()) { curs.updateWidth(curs.getWidth() + child.bounds.getWidth());}
        return curs;
    }

    // sets the composition to this column and then calls the compositors compose to begin formatting.
    public void compose() {
        formatter.setComposition(this);
        super.compose();
    }

    @Override
    void insert(Glyph glyph, int position) throws PenguineException {
        glyph.parent = this;
        children.add(position, glyph);
        // but probbaly need to send the root parent here to start reformatting
        Composition comp = this.getRootGlyph(this); // I am not sure about this since the parent is a Glyph but I need it to be a composition in this case.
        formatter.setComposition((comp));
        formatter.format();
        // will need to reformat here
        // get root and pass it to reformat? k
    }

}
