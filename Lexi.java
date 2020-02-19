/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * */
public class Lexi {
    public static void main(String[] args) {
        SwingWindow swingWin = new SwingWindow("Lexi");
        CompositeGlyph doc = new Column(swingWin); // Parent Glyph that holds all the others
        CompositeGlyph row = new Row(swingWin);
        CompositeGlyph row2 = new Row(swingWin);
        Glyph letterCol = new Column(swingWin);
        try {
            letterCol.insert(new Character('x'),0);
            letterCol.insert(new Character('y'), 1);
            letterCol.insert(new Character('z'),2);

            row.insert(new Character('a'),0);
            row.insert(new Rectangle(10,15), 1);
            row.insert(letterCol, 2);
            row.insert(new Character('b'), 3);

            row2.insert(new Character('x'),0);
            row2.insert(new Rectangle(15, 10),1);
            row2.insert(new Character('z'), 2);

            doc.insert(row,0);
            doc.insert(row2, 1);
        } catch (OperationNotSupported e) {
            e.printStackTrace();
        }
        swingWin.setContents(doc);
    }
}
