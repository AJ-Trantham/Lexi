package iterators;
import glyph.Glyph;

import java.util.ArrayList;

/** Iterator (257): Concrete Iterator */
public class ArrayListIterator<T> implements Iterator {

    private int pos;
    private ArrayList<Glyph> tArrayList;

    public ArrayListIterator(ArrayList<Glyph> list) {
        this.tArrayList = list;
        pos = 0; // inti can reset this if needed
    }

    @Override
    public void init() {
        pos = 0;
    }

    @Override
    public void next() {
        pos++;
    }

    @Override
    public boolean isDone() {
        return tArrayList.size() <= pos;
    }

    @Override
    public Glyph currentItem() {
        return tArrayList.get(pos);
    }

}
