import exceptions.OperationNotSupported;
import glyph.*;
import glyph.Character;
import widget.*;
import widget.AbstractButton;
import window.*;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * To Run: javac Lexi.java, java Lexi
 */
public class Lexi {
    public static void main(String[] args) {
        System.out.println(System.getenv("LexiLook"));
        SwingWindow swingWin = new SwingWindow("Lexi");
        //testBorderCol();


        //Button and label demo
        //Glyph bb = getBorderedButton(swingWin);
        Glyph lab = getLabel(swingWin);
        testFinalBorderScroll(swingWin, lab);

        //simple column height test
        //testSimpleColumn(swingWin);
    }

    private static void testSimpleColumn(SwingWindow swingWin) {
        Glyph borderedGlyph = new BorderDecorator(swingWin,10);
        Glyph scroll = new ScrollDecorator(swingWin);
        try {
            WidgetFactory wf = WidgetFactory.getInstance();
            Glyph row = new Row(swingWin,"Button");
            Glyph btn = wf.createButton(swingWin);
            btn.insert(row,0);
            String[] strs = {"This is a", "border demonstration", "Scroller too!", "more text", "more text", "more text","more text", "more text"};
            Glyph col = new Column(swingWin, strs);
            col.insert(btn,8);
            scroll.insert(col,0);
            borderedGlyph.insert(scroll,0);
        } catch (Exception operationNotSupported) {
            operationNotSupported.printStackTrace();
        }
        swingWin.setContents(borderedGlyph);
    }

    // test utilizing fancy constructors
    private static void testFinalBorderScroll(SwingWindow swingWin, Glyph bb) {

        Glyph col1 = new Column(swingWin);
        Glyph row2 = new Row(swingWin);
        Glyph characterA = new Character('a');
        Glyph characterB = new Character('b');
        Glyph characterX = new Character('x');
        Glyph characterY = new Character('y');
        Glyph vertRect = new Rectangle(10,15);
        Glyph horsRect = new Rectangle(15,10);
        Glyph border = new BorderDecorator(swingWin,1);
        Glyph scroll = new ScrollDecorator(swingWin);
        Glyph anotherScroller = new ScrollDecorator(swingWin);
        String[] strs = {"This is a", "border demonstration", "Scroller too!"};
        Glyph col = new Column(swingWin, strs);
        Glyph doc = new Column(swingWin);
        try {
            // build row 1
            scroll.insert(col,0);
            anotherScroller.insert(scroll,0);
            //anotherScroller.insert(new Character('c'),1); -- if Embellishments try to hold more than one child exception is thrown, could insert into the child - this would be that forwarding idea
            border.insert(anotherScroller,0);
            col1.insert(characterA,0);
            col1.insert(bb,1);
            col1.insert(vertRect,2);
            col1.insert(border,3);
            col1.insert(characterB,4);
            //build row 2
            row2.insert(characterX, 0);
            row2.insert(horsRect,1);
            row2.insert(characterY,2);
            //build doc
            doc.insert(col1, 0);
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

    public static BorderDecorator getBorderedButton(SwingWindow swingWin) {
        BorderDecorator bd = new BorderDecorator(swingWin, 2);
        WidgetFactory widgetFactory = null;
        try {
            widgetFactory = WidgetFactory.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(widgetFactory.toString());
        AbstractButton button = widgetFactory.createButton(swingWin);
        Row row = new Row(swingWin, "Button");
        try {
            button.insert(row,0);
            bd.insert(button,0);
        } catch (OperationNotSupported operationNotSupported) {
            operationNotSupported.printStackTrace();
        }
        return bd;
    }

    public static AbstractLabel getLabel(SwingWindow swingWin) {
        WidgetFactory widgetFactory = null;
        try {
            widgetFactory = WidgetFactory.getInstance();
            WidgetFactory.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(widgetFactory.toString());
        AbstractLabel lab = widgetFactory.createLabel(swingWin);
        AbstractButton btn = widgetFactory.createButton(swingWin);
        String[] strs = {"This is a", "button demo", "and Label!"};
        Column col = new Column(swingWin, strs);
        Row btnRow = new Row(swingWin, "Button");

        try {
            btn.insert(btnRow,0);
            col.insert(btn,3);
            lab.insert(col,0);
            //bd.insert(button,0);
        } catch (OperationNotSupported operationNotSupported) {
            operationNotSupported.printStackTrace();
        }
        return lab;
    }
}
