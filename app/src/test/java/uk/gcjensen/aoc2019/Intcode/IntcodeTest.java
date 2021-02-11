package uk.gcjensen.aoc2019.Intcode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IntcodeTest {
    @Test public void TestSize() {
        assertEquals(5, Intcode.of(2003, 0, 10, 1, 99).size());
    }

    @Test public void TestToString() {
        assertEquals("[2003, 0, 10, 1, 99]", Intcode.of(2003, 0, 10, 1, 99).toString());
    }

    @Test public void TestReadAndWrite() {
        var intcode = Intcode.of(2003, 0, 10, 1, 99);
        intcode.write(2, 1);

        assertEquals(1, intcode.read(2L));

        // Read will be outside the program memory, so will return 0
        assertEquals(0, intcode.read(intcode.size()));

        // Write is outside the program memory so test that it's correctly expanded
        var addr = intcode.size();
        intcode.write(addr, 99);
        assertEquals(99, intcode.read(addr));
    }
}
