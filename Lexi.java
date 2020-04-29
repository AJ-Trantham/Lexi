import command.*;
import glyph.*;
import glyph.Character;
import iterators.Iterator;
import iterators.PreOrderIterator;
import widget.*;
import window.*;

/**
 * Main Driver class for the Lexi Program, a graphical text editor
 * @author AJ Trantham
 * To Run: javac Lexi.java, java Lexi
 */
public class Lexi {
    public static void main(String[] args) {
        // get Lexi Window
        ApplicationWindow window = new ApplicationWindow("Lexi");

        //init key map
        KeyMap keyMap = new KeyMap();
        keyMap.put('i', new IncrementFontCommand());
        keyMap.put('d', new DecrementFontCommand());
        keyMap.put('u', new UndoCommand());
        keyMap.put('r', new RedoCommand());
        keyMap.put('w', new WordCountCommand());
        window.setKeyMap(keyMap); // this keeps window from knowing about Glyph Commands

        // build document
        Glyph doc = new Column(window); // Parent Glyph that holds all the others
        Glyph row = new Row(window);
        Glyph row2 = new Row(window);
        //Glyph letterRow = new Row(window, "abc def ghi,jkl");
        //Glyph letterRow2 = new Row(window, "cat dog test");
        Glyph letterCol = new Column(window);
        WidgetFactory wf = null;
        Glyph bor = null;
        try {
            wf = WidgetFactory.getInstance();
            Glyph words =  new Row(window, "This is a string of words to be used for testing.");
            Glyph labelRow = new Row(window, "Label");
            Glyph label = wf.createLabel(window, labelRow);

            letterCol.insert(label, 0);
            letterCol.insert(new Character('x'),1);
            letterCol.insert(new Character('y'), 2);
            letterCol.insert(new Character('z'),3);
            letterCol.insert(words,4);

            row.insert(new Character('a'),0);
            row.insert(new Rectangle(10,15), 1);
            row.insert(letterCol, 2);
            row.insert(new Character('b'), 3);

            // build last row with buttons
            Glyph increment = new Row(window, " + ");
            Glyph decrement = new Row(window, " - ");
            Glyph fourteen = new Row(window, " 14 ");
            Glyph tweenty = new Row(window, " 20 ");

            Glyph buttonInc = wf.createButton(window, increment, new IncrementFontCommand());
            Glyph buttonDec = wf.createButton(window, decrement, new DecrementFontCommand());
            Glyph button14 = wf.createButton(window,fourteen, new ChangeFontCommand(14));
            Glyph button20 = wf.createButton(window, tweenty, new ChangeFontCommand(20));

            Glyph border1 = new BorderDecorator(window, buttonInc, 2);
            Glyph border2 = new BorderDecorator(window, buttonDec, 2);
            Glyph border3 = new BorderDecorator(window, button14, 2);
            Glyph border4 = new BorderDecorator(window, button20, 2);

            row2.insert(border1, 0);
            row2.insert(border2,1);
            row2.insert(border3, 2);
            row2.insert(border4, 3);

            doc.insert(row,0);
            doc.insert(row2, 1);
            //doc.insert(letterCol, 2);
            bor = new BorderDecorator(window, doc, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        window.setContents(bor);

//        Iterator i = new PreOrderIterator<>(bor);
//        //Iterator i = row.createIterator();
//        for(i.init();!i.isDone();i.next()) {
//            System.out.println(i.currentItem().toString());
//        }
    }
}
