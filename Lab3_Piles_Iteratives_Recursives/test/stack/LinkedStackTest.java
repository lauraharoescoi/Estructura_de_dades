package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {
    public static final int MAX = 10;

    @Test
    void testEmpty() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        assertTrue(ls.isEmpty());
    }

    @Test
    void testAddElem() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for (int i = 0; i < MAX; i++) {
            ls.push(i);
            assertEquals(ls.top(), i);
            assertFalse(ls.isEmpty());
        }

    }

    @Test
    void testPopElem() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for (int i = 0; i < MAX; i++) {
            ls.push(i);
        }
        for (int i = 0; i < MAX - 1; i++) {
            if (!ls.isEmpty()) {
                ls.pop();
                assertEquals(ls.top(), MAX - (i + 2));
                assertFalse(ls.isEmpty());
            }
        }
    }
}
