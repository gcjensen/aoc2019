package com.gcjensen.aoc2019.Intcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntcodeMachineTest {
    List<Map<String, List<Integer>>> testCases = List.of(
        // Basic test
        Map.of(
            "program", List.of(1,0,0,0,99),
            "finalMemory", List.of(2,0,0,0,99),
            "input", List.of(),
            "output", List.of()
        ),
        // Longer test
        Map.of(
            "program", List.of(1,1,1,4,99,5,6,0,99),
            "finalMemory", List.of(30,1,1,4,2,5,6,0,99),
            "input", List.of(),
            "output", List.of()
        ),
        // IO test
        Map.of(
            "program", List.of(4,2,1,0,0,0,3,3,99),
            "finalMemory", List.of(8,2,1,100,0,0,3,3,99),
            "input", List.of(100),
            "output", List.of(1)
        ),
        // Testing opcodes with parameter modes
        Map.of(
            "program", List.of(1002,3,3,2,99),
            "finalMemory", List.of(1002,3,6,2,99),
            "input", List.of(),
            "output", List.of()
        ),
        // Testing immediate parameter mode
        Map.of(
            "program", List.of(101,-89,0,0,99),
            "finalMemory", List.of(12,-89,0,0,99),
            "input", List.of(),
            "output", List.of()
        ),
        // Jump test in immediate mode
        Map.of(
            "program", List.of(3,3,1105,-1,9,1101,0,0,12,4,12,99,1),
            "finalMemory", List.of(3,3,1105,26,9,1101,0,0,12,4,12,99,1),
            "input", List.of(26),
            "output", List.of(1)
        ),
        // Jump test in position mode
        Map.of(
            "program", List.of(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9),
            "finalMemory", List.of(3,12,6,12,15,1,13,14,13,4,13,99,0,0,1,9),
            "input", List.of(0),
            "output", List.of(0)
        ),
        // Equal test (equal to 8 => true)
        Map.of(
            "program", List.of(3,9,8,9,10,9,4,9,99,-1,8),
            "finalMemory", List.of(3,9,8,9,10,9,4,9,99,1,8),
            "input", List.of(8),
            "output", List.of(1)
        ),
        // Equal test (equal to 8 => false)
        Map.of(
            "program", List.of(3,9,8,9,10,9,4,9,99,-1,8),
            "finalMemory", List.of(3,9,8,9,10,9,4,9,99,0,8),
            "input", List.of(7),
            "output", List.of(0)
        ),
        // Less than test (less than 8 => true)
        Map.of(
            "program", List.of(3,3,1107,-1,8,3,4,3,99),
            "finalMemory", List.of(3,3,1107,1,8,3,4,3,99),
            "input", List.of(7),
            "output", List.of(1)
        ),
        // Less than test (less than 8 => false)
        Map.of(
            "program", List.of(3,3,1107,-1,8,3,4,3,99),
            "finalMemory", List.of(3,3,1107,0,8,3,4,3,99),
            "input", List.of(9),
            "output", List.of(0)
        ),
        // More complex example combining the above (outputs 1001 for input greater than 8)
        Map.of(
            "program", List.of(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104, 999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99),
            "finalMemory", List.of(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,1001,9,1002,21,125,20,4,20,1105,1,46,104, 999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99),
            "input", List.of(9),
            "output", List.of(1001)
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
