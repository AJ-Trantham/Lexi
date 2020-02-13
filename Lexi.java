/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * */
public class Lexi {
    public static void main(String[] args) {
        SwingWindow swingWin = new SwingWindow("Lexi");
        Glyph character = new Character('c');
        Glyph recTest = new Rectangle(10,10);
        Glyph col = new Column();
        Glyph row = new Row();
        try {
            row.insert(character,0);
            row.insert(recTest, 1);
            col.insert(row,0);
            col.insert(new Rectangle(20,20), 1);
        } catch (PenguineException e) {
            e.printStackTrace();
        }
        swingWin.setContents(col);
    }
}
