package stack;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

    private Entry<E> last;
    private int size;

    private static class Entry<E> {
        Entry<E> previous;
        E element;

        Entry(Entry<E> previous, E element) {
            this.previous = previous;
            this.element = element;
        }
    }

    @Override
    public void push(E elem) {
        if (size == 0) {
            Entry theEntry = new Entry(null, elem);
            last = theEntry;
        } else {
            Entry theEntry = new Entry(last, elem);
            last = theEntry;
        }
        size++;
    }

    @Override
    public E top() {
        if (size == 0) throw new NoSuchElementException();
        return last.element;
    }

    @Override
    public void pop() {
        if (size == 0) throw new NoSuchElementException();
        last.element = null;
        last = last.previous;
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
