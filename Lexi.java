/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * */
public class Lexi {
    public static void main(String[] args) {
        SwingWindow swingWin = new SwingWindow("Lexi");
        Glyph character = new Character('c');
        //Glyph recTest = new Rectangle(0,0,10,10);
        //Glyph row = new CompositeRow();
//        try {
//            //row.insert(character,0);
//            //row.insert(recTest, 1);
//        } catch (PenguineException e) {
//            e.printStackTrace();
//        }

        // should set contents only be called once with the root glyph?
        // yes I think so, the whole document is technically one row or col, set contents to it
        // and then its draw method will recursively draw all the children.
        swingWin.setContents(character);
    }
}
