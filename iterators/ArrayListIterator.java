package iterators;
import glyph.Glyph;

import java.util.ArrayList;

/** Iterator (257): Concrete Iterator */
public class ArrayListIterator<T> implements Iterator<T> {

    private int pos;
    private ArrayList<T> tArrayList;

    public ArrayListIterator(ArrayList<T> list) {
        this.tArrayList = list;
        this.init();
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
    public T currentItem() {
        return tArrayList.get(pos);
    }

}
