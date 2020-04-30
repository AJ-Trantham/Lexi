package iterators;

import java.util.Stack;

/**
 * Iterator (257): Concrete Iterator
 * T extends IteratorNode puts a constraint on the Type of T.
 * T can be any type that implements the IteratorNode interface to
 * ensure we have a createIterator() method.
 */
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
