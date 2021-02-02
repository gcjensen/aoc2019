package com.gcjensen.aoc2019.Intcode;

import static org.junit.Assert.*;
import org.junit.Test;

public class IntcodeMachineTest {
    private final Intcode testIntcode = Intcode.of(1,1,1,4,99,5,6,0,99);

    @Test
    public void testRun() {
        assertEquals(Intcode.of(30,1,1,4,2,5,6,0,99), new IntcodeMachine(testIntcode).run());
    }
}
