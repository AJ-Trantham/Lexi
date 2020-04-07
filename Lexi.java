import exceptions.OperationNotSupported;
import glyph.*;
import glyph.Character;
import widget.*;
import window.*;

/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * To Run: javac Lexi.java, java Lexi
 */
public class Lexi {
    public static void main(String[] args) {
        ApplicationWindow swingWin = new ApplicationWindow("Lexi");
        swingWin.getInstance(swingWin);
        Glyph doc = new Column(swingWin); // Parent Glyph that holds all the others
        Glyph row = new Row(swingWin);
        Glyph row2 = new Row(swingWin);
        Glyph letterCol = new Column(swingWin);
        WidgetFactory wf = null;
        Glyph bor = null;
        try {
            wf = WidgetFactory.getInstance();
            Glyph labelRow = new Row(swingWin, "Label");
            Glyph label = wf.createLabel(swingWin, labelRow);
            Glyph buttonRow = new Row(swingWin, "Button");
            Glyph button = wf.createButton(swingWin, buttonRow);

            letterCol.insert(label, 0);
            letterCol.insert(new Character('x'),1);
            letterCol.insert(new Character('y'), 2);
            letterCol.insert(new Character('z'),3);

            row.insert(new Character('a'),0);
            row.insert(new Rectangle(10,15), 1);
            row.insert(letterCol, 2);
            row.insert(new Character('b'), 3);

            row2.insert(new Character('x'),0);
            row2.insert(new Rectangle(15, 10),1);
            row2.insert(button,2);
            row2.insert(new Character('z'), 3);

            doc.insert(row,0);
            doc.insert(row2, 1);
            bor = new BorderDecorator(swingWin, doc, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        swingWin.setContents(bor);
    }
}
