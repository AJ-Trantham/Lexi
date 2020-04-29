package iterators;

import glyph.Glyph;

/** Iterator (257): Concrete Iterator */
public class NullIterator<T> implements Iterator {

    @Override
    public void init() {
        // nothing
    }

    @Override
    public void next() {
        // nothing
    }

    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public Glyph currentItem() {
        return null;
    }
}
