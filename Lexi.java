import exceptions.OperationNotSupported;
import glyph.*;
import glyph.Character;
import window.*;

/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * To Run: javac Lexi.java, java Lexi
 */
public class Lexi {
    public static void main(String[] args) {
        SwingWindow swingWin = new SwingWindow("Lexi");
        CompositeGlyph doc = new Column(swingWin); // Parent glyph.Glyph that holds all the others
        CompositeGlyph row = new Row(swingWin);
        CompositeGlyph row2 = new Row(swingWin);
        Glyph letterCol = new Column(swingWin);
        Glyph border = new BorderDecorator(swingWin, 1);
        Glyph outerBorder = new BorderDecorator(swingWin, 1);
//            //outerBorder.insert();
        Glyph innerBorder = new BorderDecorator(swingWin, 2);
        Glyph scroll = new ScrollDecorator(swingWin);
        try {

//            //border.insert(new glyph.Character('c'),0);
            letterCol.insert(new Character('x'),0);
            letterCol.insert(new Character('y'),1);
            Glyph b = new BorderDecorator(swingWin, 3);
            b.insert(new Character('z'),0);
            letterCol.insert(b,2);
////
//            //innerBorder.insert(letterCol,0);
//

//
            row.insert(new Character('a'),0);
            row.insert(new Rectangle(10,15), 1);
            row.insert(letterCol, 2);
            row.insert(new Character('b'), 3);
            Glyph scrollTest = new ScrollDecorator(swingWin);
            //scroll.insert(row,0);
            scrollTest.insert(row,0);
//
//            row2.insert(new glyph.Character('x'),0);
//            row2.insert(new glyph.Rectangle(15, 10),1);
//            row2.insert(new glyph.Character('z'), 2);
          //border.insert(scroll,0);
          //outerBorder.insert(border,0);
          border.insert(scrollTest,0);
          Glyph insideScroll = new ScrollDecorator(swingWin);
          insideScroll.insert(new Character('c'),0);
          innerBorder.insert(insideScroll,0);
          doc.insert(border,0);
          doc.insert(innerBorder,1);
          outerBorder.insert(doc,0);
          scroll.insert(outerBorder,0);
          //row2.insert(outerBorder,1);

          //doc.insert(outerBorder, 1);
        } catch (OperationNotSupported e) {
            e.printStackTrace();
        }
        swingWin.setContents(scroll);
    }
}
