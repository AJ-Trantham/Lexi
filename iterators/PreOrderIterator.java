package iterators;

import glyph.Glyph;
import java.util.Stack;

// TODO: Solution having glyph implement a IteratorNode (Iterable) interface garentees we have a createIterator() method.
// but it also lets us return type Glyph. So T in this case can be any Type that is a Glyph that implements the Iterable interface
// FOr other cases T could be anything. Since T is Glyph our currentItem() should be able to return type T
// Need to return type T or else this wouldn't be reusable.

//Can I get rid of the ItoratorNode<T> the T part????

/** Iterator (257): Concrete Iterator */
public class PreOrderIterator<T extends IteratorNode<T>> implements Iterator {
    private IteratorNode<T> root;
    private Stack<Iterator<T>> stack;


    public PreOrderIterator(IteratorNode<T> root) {
        this.root=root;
        stack = new Stack<>();
    }

    @Override
    public void init() {
        Iterator<T> i = root.createIterator();
        i.init();
        stack.push(i);
    }

    @Override
    public void next() {
        Iterator<T> currentIterator = stack.peek();
        T topItem = currentIterator.currentItem();
        Iterator<T> i = topItem.createIterator();
        i.init();
        stack.push(i);
        // this will only start with a null iterator
        while( !stack.isEmpty() && stack.peek().isDone() ) {
            stack.pop();
            if (!stack.isEmpty() && !stack.peek().isDone()) {
                stack.peek().next();
            }
        }
    }

    @Override
    public boolean isDone() {
        return stack.isEmpty();
    }

    @Override
    public T currentItem() {
        Iterator<T> currentIterator = stack.peek();
        return currentIterator.currentItem();
    }

}
