package heaps;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TripletTest {
    @Test
    void testSomeCompare() {
        var triplet1 = new HeapQueue.Triplet<Object, Integer>(1, new Object(), 1L);
        var triplet2 = new HeapQueue.Triplet<Object, Integer>(2, new Object(), 2L);
        var triplet3 = new HeapQueue.Triplet<Object, Integer>(null, 2, 3L);
        var triplet4 = new HeapQueue.Triplet<Object, Integer>(null, 3, 4L);
        assertTrue(triplet1.compareTo(triplet2) < 0);
        assertTrue(triplet2.compareTo(triplet3) > 0);
        assertTrue(triplet3.compareTo(triplet4) < 0);
        assertTrue(triplet3.compareTo(triplet2) < 0);
    }

    @Test
    void testEmptyHeap() {
        var heap = new HeapQueue<Integer, Integer>();
        assertEquals(heap.size(), 0);
    }

    @Test
    void testAdd() {
        var heap = new HeapQueue<Integer, Integer>();
        heap.add(50, 10);
        var triplet = heap.element();
        assertEquals(triplet, 50);
    }

    @Test
    void testRemove() {
        var heap = new HeapQueue<Integer, Integer>();
        for (int i = 0; i < 5; i++) {
            heap.add(i + 1, i);
        }
        for (int j = 5; j > 0; j--) {
            heap.remove();
            assertEquals(heap.size(), j - 1);
        }
    }

    @Test
    void testOrder() {
        var heap = new HeapQueue<Integer, Integer>();
        for (int i = 0; i < 5; i++) {
            heap.add(i + 1, i);
        }
        for (int j = 5; j > 0; j--) {
            assertEquals(heap.remove(), j);
        }

    }
}