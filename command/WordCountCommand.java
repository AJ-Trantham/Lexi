package command;

import window.Window;
import analysis.*;
import glyph.*;
import iterators.*;

/**
 * Counts all the words in a document
 * Command (233): ConcreteCommand
 * Prototype (117): ConcretePrototype
 */
public class WordCountCommand extends Command {

    public WordCountCommand() {
        super(false);
    }

    @Override
    public void execute(Window window) {
        GlyphVisitor v=new WordCountVisitor();
        PreOrderIterator<Glyph> i=new PreOrderIterator<Glyph>(window.getRoot());
        for (i.init(); !i.isDone(); i.next())
            i.currentItem().accept(v);
        System.out.println(v);
    }
}
