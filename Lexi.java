/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * To Run: javac Lexi.java, java Lexi
 */
public class Lexi {
    public static void main(String[] args) {
        SwingWindow swingWin = new SwingWindow("Lexi");
        CompositeGlyph doc = new Column(swingWin); // Parent Glyph that holds all the others
        CompositeGlyph row = new Row(swingWin);
        CompositeGlyph row2 = new Row(swingWin);
        Glyph letterCol = new Column(swingWin);
        try {
            Glyph border = new BorderDecorator(swingWin, 5);
            Glyph outerBorder = new BorderDecorator(swingWin, 5);
            //outerBorder.insert();
            Glyph innerBorder = new BorderDecorator(swingWin, 2);
            //border.insert(new Character('c'),0);
            letterCol.insert(new Character('x'),0);
            letterCol.insert(new Character('y'),1);
            letterCol.insert(new Character('z'),2);
//
            innerBorder.insert(letterCol,0);
            row.insert(new Character('a'),0);
            row.insert(new Rectangle(10,15), 1);
            row.insert(innerBorder, 2);
            row.insert(new Character('b'), 3);
//
//            row2.insert(new Character('x'),0);
//            row2.insert(new Rectangle(15, 10),1);
//            row2.insert(new Character('z'), 2);
          border.insert(row,0);
          //outerBorder.insert(border,0);
          doc.insert(border,0);

          //row2.insert(outerBorder,1);

          //doc.insert(outerBorder, 1);
        } catch (OperationNotSupported e) {
            e.printStackTrace();
        }
        swingWin.setContents(doc);
    }
}
