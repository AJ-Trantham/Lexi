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
        //testBorderCol();
        testFinalBorderScroll();
    }

    // test utilizing fancy constructors
    private static void testFinalBorderScroll() {
        SwingWindow swingWin = new SwingWindow("Lexi");
        Glyph row1 = new Row(swingWin);
        Glyph row2 = new Row(swingWin);
        Glyph characterA = new Character('a');
        Glyph characterB = new Character('b');
        Glyph characterX = new Character('x');
        Glyph characterY = new Character('y');
        Glyph vertRect = new Rectangle(10,15);
        Glyph horsRect = new Rectangle(15,10);
        Glyph border = new BorderDecorator(swingWin,5);
        Glyph scroll = new ScrollDecorator(swingWin);
        String[] strs = {"This is a", "border demonstration", "Scroller too!"};
        Glyph col = new Column(swingWin, strs);
        Glyph doc = new Column(swingWin);
        try {
            // build row 1
            scroll.insert(col,0);
            border.insert(scroll,0);
            row1.insert(characterA,0);
            row1.insert(vertRect,1);
            row1.insert(border,2);
            row1.insert(characterB,3);
            //build row 2
            row2.insert(characterX, 0);
            row2.insert(horsRect,1);
            row2.insert(characterY,2);
            //build doc
            doc.insert(row1, 0);
            doc.insert(row2,1);

        } catch (OperationNotSupported operationNotSupported) {
            operationNotSupported.printStackTrace();
        }
        swingWin.setContents(doc);
    }

    private static void testBorderCol() {
        SwingWindow swingWin = new SwingWindow("Lexi");
        CompositeGlyph doc = new Column(swingWin); // Parent glyph.Glyph that holds all the others
        CompositeGlyph row = new Row(swingWin);
        Glyph letterCol = new Column(swingWin);
        Glyph border = new BorderDecorator(swingWin, 1);
        Glyph outerBorder = new BorderDecorator(swingWin, 1);
        Glyph innerBorder = new BorderDecorator(swingWin, 2);
        Glyph scroll = new ScrollDecorator(swingWin);
        try {
            letterCol.insert(new Character('x'), 0);
            letterCol.insert(new Character('y'), 1);
            Glyph b = new BorderDecorator(swingWin, 3);
            b.insert(new Character('z'), 0);
            letterCol.insert(b, 2);
            row.insert(new Character('a'), 0);
            row.insert(new Rectangle(10, 15), 1);
            row.insert(letterCol, 2);
            row.insert(new Character('b'), 3);
            Glyph scrollTest = new ScrollDecorator(swingWin);
            scrollTest.insert(row, 0);
            border.insert(scrollTest, 0);
            Glyph insideScroll = new ScrollDecorator(swingWin);
            insideScroll.insert(new Character('c'), 0);
            innerBorder.insert(insideScroll, 0);
            doc.insert(border, 0);
            doc.insert(innerBorder, 1);
            outerBorder.insert(doc, 0);
            scroll.insert(outerBorder, 0);
        } catch (OperationNotSupported e) {
            e.printStackTrace();
        }
        swingWin.setContents(scroll);
    }
}
