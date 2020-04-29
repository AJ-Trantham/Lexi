package analysis;

import glyph.*;
import glyph.Character;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Visitor (331): Concrete Visitor
 * Each of these methods controls what happens when we vist a certain glyph
 * All glyphs are visited since we iterate over each one. Mainly here each method
 * needs to determine the end of a glyph
 */
public class WordCountVisitor implements GlyphVisitor {

    private ArrayList<String> wordList;
    private String currentWord;
    private Stack<Glyph> composites;
    private ArrayList<String> DELIMITERS =new ArrayList<>();

    public WordCountVisitor() {
        wordList = new ArrayList<>();
        composites = new Stack<>();
        currentWord = "";
        DELIMITERS.add(".");
        DELIMITERS.add(",");
        DELIMITERS.add(";");
        DELIMITERS.add(" ");
        DELIMITERS.add("?");
        DELIMITERS.add("!");
    }

    @Override
    public void visit(Glyph e) {
        composites.push(e);
    }

    @Override
    public void visit(Character e) {
        // currentComposite should always be set since the document is composed of composite glyphs
        if (composites.peek().isLast(e)) {
            if (!DELIMITERS.contains(String.valueOf(e.getCharacter())))
                currentWord += e.getCharacter();
            if (!currentWord.equals(""))
                wordList.add(currentWord);
            currentWord = "";
            composites.pop();
        } else {
            if (!DELIMITERS.contains(String.valueOf(e.getCharacter())))
                currentWord += e.getCharacter();
            else {
                if (!currentWord.equals(""))
                    wordList.add(currentWord);
                currentWord = "";
            }
        }
    }

    @Override
    public void visit(Rectangle e) {
        if (!currentWord.equals("")) {
            wordList.add(currentWord);
            currentWord = "";
        }
    }

    @Override
    public void visit(Row e) {
        // add row to stack
        if (!currentWord.equals("")) {
            wordList.add(currentWord);
            currentWord = "";
        }
        composites.push(e);
    }

    @Override
    public void visit(Column e) {
        if (!currentWord.equals("")) {
            wordList.add(currentWord);
            currentWord = "";
        }
        composites.push(e);
    }

    @Override
    public void visit(Embellishment e) {
        // don't need to add embellishments since they always contain composites
        if (!currentWord.equals("")) {
            wordList.add(currentWord);
            currentWord = "";
        }
    }

    public String toString() {
        String str = "";
        for (String w: wordList) {
            str += w + '\n';
        }
        return str;
    }
}
