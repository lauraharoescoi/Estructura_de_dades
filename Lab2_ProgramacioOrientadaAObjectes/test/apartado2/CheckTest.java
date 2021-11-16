package apartado2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChecksTest {
    List<Integer> l;
    Iterator<Integer> it;

    @BeforeEach
    void setUp() {
        l = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        it = l.iterator();
    }

    @Test
    void removeIfLocalClass() {
        class CheckEven implements Check<Integer> {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        }

        Checks.removeIf(it, new CheckEven());
        var expected = List.of(1, 3, 5, 7);
        assertEquals(List.of(1, 3, 5, 7), l);
    }

    @Test
    void removeIfAnonymousClass() {
        Checks.removeIf(it, new Check<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        });
        assertEquals(List.of(1, 3, 5, 7), l);
    }

    @Test
    void removeIfLambda() {
        Checks.removeIf(it, n -> n % 2 == 0);
        assertEquals(List.of(1, 3, 5, 7), l);
    }
}