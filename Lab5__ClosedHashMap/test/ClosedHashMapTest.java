import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClosedHashMapTest {
    @Test
    void testConstruct() {
        ClosedHashMap<Integer, Integer> closedHashMap = new ClosedHashMap<>();
        assertEquals(0, closedHashMap.size());
        assertTrue(closedHashMap.isEmpty());
    }
    @Test
    void testPutGet() {
        ClosedHashMap<Integer, Integer> closedHashMap = new ClosedHashMap<>();
        assertNull(closedHashMap.put(2, 4));
        assertEquals(4, closedHashMap.put(2, 7));
        assertEquals(7, closedHashMap.get(2));
        assertNull(closedHashMap.put(4, 6));
        assertNull(closedHashMap.put(1, 8));
        assertEquals(6, closedHashMap.get(4));
        assertEquals(8, closedHashMap.get(1));
    }

    @Test
    void testContainsKey() {
        ClosedHashMap<Integer, Integer> closedHashMap = new ClosedHashMap<>();
        assertNull(closedHashMap.put(2, 4));
        assertEquals(4, closedHashMap.put(2, 7));
        assertTrue(closedHashMap.containsKey(2));
    }

    @Test
    void testRemove() {
        ClosedHashMap<Integer, Integer> closedHashMap = new ClosedHashMap<>();
        assertNull(closedHashMap.put(2, 4));
        assertEquals(4, closedHashMap.put(2, 5));
        assertNull(closedHashMap.put(3, 1));
        assertEquals(5, closedHashMap.remove(2));
        assertEquals(1, closedHashMap.size());
    }
}
