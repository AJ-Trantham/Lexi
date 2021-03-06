package iterators;

/**Iterator (257): Iterator */
public interface Iterator<T> {
    /** Sets iterator to point to the first element in the list */
    void init();

    /** Advances the iterator to the next item */
    void next();

    /** Returns whether the list pointer is beyond the last element*/
    boolean isDone();

    /** Returns the current item the iterator points to */
    T currentItem();
}
