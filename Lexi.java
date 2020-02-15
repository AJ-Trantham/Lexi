/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * */
public class Lexi {
    public static void main(String[] args) {
        SwingWindow swingWin = new SwingWindow("Lexi");
        Glyph character = new Character('c');
        Glyph recTest = new Rectangle(10,10);
        Glyph col = new Column(swingWin);
        CompositeGlyph row = new Row(swingWin);
        try {
            col.insert(character,0);
            //col.insert(new Row(swingWin), 1);
            //col.insert(new Character('c'), 1);
            //col.insert(new Character('c'), 2);
            //col.insert(new Character('c'), 3);
            row.insert(new Character('i'),0);
            row.insert(new Character('e'), 1);
            row.insert(new Rectangle(10, 20), 2);
            //row.insert(new Character('c'), 2);
            //row.insert(new Character('c'), 3);
            //col.insert(row,0);
            col.insert(row,1);
            col.insert(new Rectangle(20,20), 2);
            Row testRow2 = new Row(swingWin);
            testRow2.insert(new Character('a'), 0);
            testRow2.insert(new Character('b'), 1);
            col.insert(new Character('s'), 3);
        } catch (PenguineException e) {
            e.printStackTrace();
        }
        //Composition comp = new Composition(swingWin);
        //comp.formatter.setComposition(row);
        //comp.compose();
        swingWin.setContents(col);
    }
}
