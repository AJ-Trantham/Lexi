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
class Lexi2 {
    public static void main(String[] args) {
        // get Lexi Window
        ApplicationWindow window = new ApplicationWindow("Lexi2");

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

        Glyph letterRow = new Row(window, "abc def ghi,jkl");
        Glyph letterRow2 = new Row(window, "cat dog test more;words. and,, other... word2!word don't");
        Glyph letterRow3 = new Row(window, "more.words.test,test?");
        Glyph letterCol = new Column(window);
        try {

            doc.insert(letterRow,0);
            doc.insert(letterRow2, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        window.setContents(doc);
    }
}

