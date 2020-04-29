//package iterators;
//import java.util.Vector;
//
///** Iterator (257): Concrete Iterator */
//public class VectorIterator<T> implements Iterator<T> {
//
//    private int pos;
//    private Vector<T> vector;
//
//    public VectorIterator(Vector<T> list) {
//        this.vector = list;
//        //init();
//    }
//
//    @Override
//    public void init() {
//        pos = 0;
//    }
//
//    @Override
//    public void next() {
//        pos++;
//    }
//
//    @Override
//    public boolean isDone() {
//        return vector.size() <= pos;
//    }
//
//    @Override
//    public T currentItem() {
//        return vector.get(pos);
//    }
//}
