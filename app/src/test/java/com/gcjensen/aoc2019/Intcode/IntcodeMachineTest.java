package com.gcjensen.aoc2019.Intcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntcodeMachineTest {
    List<Map<String, List<Integer>>> testCases = List.of(
        Map.of(
            "program", List.of(1,0,0,0,99),
            "finalMemory", List.of(2,0,0,0,99),
            "input", List.of(),
            "output", List.of()
        ),
        Map.of(
            "program", List.of(1,1,1,4,99,5,6,0,99),
            "finalMemory", List.of(30,1,1,4,2,5,6,0,99),
            "input", List.of(),
            "output", List.of()
        ),
        Map.of(
            "program", List.of(4,2,1,0,0,0,3,3,99),
            "finalMemory", List.of(8,2,1,100,0,0,3,3,99),
            "input", List.of(100),
            "output", List.of(1)
        ),
        Map.of(
            "program", List.of(1002,3,3,2,99),
            "finalMemory", List.of(1002,3,6,2,99),
            "input", List.of(),
            "output", List.of()
        ),
        Map.of(
            "program", List.of(101,-89,0,0,99),
            "finalMemory", List.of(12,-89,0,0,99),
            "input", List.of(),
            "output", List.of()
        )
    );

    @Test
    public void testRun() {
        testCases.forEach(test -> {
            var testIO = new TestIO(new ArrayList<>(test.get("input")));
            var machine = IntcodeMachine.withIO(testIO, new Intcode(test.get("program")));
            machine.run();

            assertEquals(new Intcode(test.get("finalMemory")), machine.dumpMemory());
            assertEquals(test.get("output"), testIO.getOutput());
        });
    }
}
