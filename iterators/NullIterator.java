package iterators;

/** Iterator (257): Concrete Iterator */
public class NullIterator<T> implements Iterator<T> {

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
    public T currentItem() {
        return null;
    }
}
