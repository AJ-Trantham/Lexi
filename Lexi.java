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
        ApplicationWindow window = new ApplicationWindow("Lexi");
        ///ApplicationWindow window2 = new ApplicationWindow("test");
        //Glyph testRow = new Row(window2, "This is a test. Do two windows appear?");
        Glyph doc = new Column(window); // Parent Glyph that holds all the others
        Glyph row = new Row(window);
        Glyph row2 = new Row(window);
        Glyph letterCol = new Column(window);
        WidgetFactory wf = null;
        Glyph bor = null;
        try {
            wf = WidgetFactory.getInstance();
            Glyph labelRow = new Row(window, "Label");
            Glyph label = wf.createLabel(window, labelRow);
            Glyph buttonRow = new Row(window, "Button");
            Glyph button = wf.createButton(window, buttonRow);

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
            bor = new BorderDecorator(window, doc, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //window2.setContents(testRow);
        window.setContents(bor);
    }
}
