package partitions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PartitionsGoldenTest {
    public static final int MAX = 20;

    @Test
    void golden() {
        for (int sum = 0; sum <= MAX; sum++) {
            var rec = Partitions.numPartitionsRec(sum);
            var ite = Partitions.numPartitionsIter(sum);
            assertEquals(rec, ite);
        }
    }
}
