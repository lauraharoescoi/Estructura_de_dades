package heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapQueue<V, P extends Comparable<? super P>>
        implements PriorityQueue<V, P> {

    private final ArrayList<Triplet<V, P>> triplets;
    private long nextTimeStamp = 0L;

    static class Triplet<V, P extends Comparable<? super P>>
            implements Comparable<Triplet<V, P>> {
        private final P priority;
        private final V value;
        private final long timeStamp;

        Triplet(P priority, V value, long timeStamp) {
            this.value = value;
            this.priority = priority;
            this.timeStamp = timeStamp;
        }

        @Override
        public int compareTo(Triplet<V, P> o) {
            if (o == null) throw new NullPointerException();
            if (o.priority == this.priority) return Long.compare(this.timeStamp, o.timeStamp);
            if (o.priority == null || this.priority == null) return comparetoNull();
            else return this.priority.compareTo(o.priority);
        }

        private int comparetoNull() {
            if (this.priority == null) return -1;
            else return 1;
        }
    }

    public HeapQueue() {
        this.triplets = new ArrayList<Triplet<V, P>>();
        this.triplets.add(null);
    }

    @Override
    public void add(V value, P priority) {
        var triplet = new Triplet<>(priority, value, nextTimeStamp);
        this.nextTimeStamp++;
        this.triplets.add(triplet);
        orderAdd();
    }

    private void orderAdd() {
        int indexChild = size();
        orderAdd(indexChild);
    }

    private void orderAdd(int indexChild) {
        if (hasParent(indexChild)) {
            int indexParent = parent(indexChild);
            if (this.triplets.get(indexParent).compareTo(this.triplets.get(indexChild)) < 0) {
                swap(indexParent, indexChild);
                orderAdd(indexParent);
            }
        }
    }

    private void swap(int parent, int child) {
        var tripletAux = this.triplets.get(parent);
        this.triplets.set(parent, this.triplets.get(child));
        this.triplets.set(child, tripletAux);
    }

    @Override
    public V remove() {
        var element = element();
        swap(1, size());
        this.triplets.remove(size());
        orderRemove();
        return element;
    }

    private void orderRemove() {
        int indexParent = 1;
        orderRemove(indexParent);
    }

    private void orderRemove(int indexParent) {
        int indexChild;
        if (hasLeft(indexParent)) {
            int indexLeft = left(indexParent);
            if (hasRight(indexParent)) {
                int indexRight = right(indexParent);
                indexChild = (this.triplets.get(indexLeft).compareTo(this.triplets.get(indexRight)) > 0) ? indexLeft : indexRight;
            } else {
                indexChild = indexLeft;
            }
            if (this.triplets.get(indexParent).compareTo(this.triplets.get(indexChild)) < 0)
                swap(indexParent, indexChild);
            orderRemove(indexChild);
        }
    }

    @Override
    public V element() {
        if (size() == 0) throw new NoSuchElementException();
        return this.triplets.get(1).value;
    }

    @Override
    public int size() {
        return this.triplets.size() - 1;
    }

    static int parent(int index) {
        return index / 2;
    }

    static int left(int index) {
        return index * 2;
    }

    static int right(int index) {
        return (index * 2) + 1;
    }

    boolean isValid(int index) {
        return 1 <= index && index <= size();
    }

    boolean hasParent(int index) {
        return isValid(parent(index));
    }

    boolean hasLeft(int index) {
        return isValid(left(index));
    }

    boolean hasRight(int index) {
        return isValid(right(index));
    }
}
