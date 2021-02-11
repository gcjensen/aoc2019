package uk.gcjensen.aoc2019.Intcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

import uk.gcjensen.aoc2019.LongList;
import org.junit.Test;

public class IntcodeMachineTest {
    List<Map<String, List<Long>>> testCases = List.of(
        // Basic test
        Map.of(
            "program", LongList.of(1,0,0,0,99),
            "input", LongList.of(),
            "output", LongList.of()
        ),
        // Longer test
        Map.of(
            "program", LongList.of(1,1,1,4,99,5,6,0,99),
            "input", LongList.of(),
            "output", LongList.of()
        ),
        // IO test
        Map.of(
            "program", LongList.of(4,2,1,0,0,0,3,3,99),
            "input", LongList.of(100),
            "output", LongList.of(1)
        ),
        // Testing opcodes with parameter modes
        Map.of(
            "program", LongList.of(1002,3,3,2,99),
            "input", LongList.of(),
            "output", LongList.of()
        ),
        // Testing immediate parameter mode
        Map.of(
            "program", LongList.of(101,-89,0,0,99),
            "input", LongList.of(),
            "output", LongList.of()
        ),
        // Jump test in immediate mode
        Map.of(
            "program", LongList.of(3,3,1105,-1,9,1101,0,0,12,4,12,99,1),
            "input", LongList.of(26),
            "output", LongList.of(1)
        ),
        // Jump test in position mode
        Map.of(
            "program", LongList.of(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9),
            "input", LongList.of(0),
            "output", LongList.of(0)
        ),
        // Equal test (equal to 8 => true)
        Map.of(
            "program", LongList.of(3,9,8,9,10,9,4,9,99,-1,8),
            "input", LongList.of(8),
            "output", LongList.of(1)
        ),
        // Equal test (equal to 8 => false)
        Map.of(
            "program", LongList.of(3,9,8,9,10,9,4,9,99,-1,8),
            "input", LongList.of(7),
            "output", LongList.of(0)
        ),
        // Less than test (less than 8 => true)
        Map.of(
            "program", LongList.of(3,3,1107,-1,8,3,4,3,99),
            "input", LongList.of(7),
            "output", LongList.of(1)
        ),
        // Less than test (less than 8 => false)
        Map.of(
            "program", LongList.of(3,3,1107,-1,8,3,4,3,99),
            "input", LongList.of(9),
            "output", LongList.of(0)
        ),
        // More complex example combining the above (outputs 1001 for input greater than 8)
        Map.of(
            "program", LongList.of(
                3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,
                21,125,20,4,20,1105,1,46,104, 999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99
            ),
            "input", LongList.of(9),
            "output", LongList.of(1001)
        ),
        // Testing relative base adjustment opcode
        Map.of(
            "program", LongList.of(109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99),
            "input", LongList.of(),
            "output", LongList.of(109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99)
        ),
        // Testing output of very large number
        Map.of(
            "program", LongList.of(1102,34915192,34915192,7,4,7,99,0),
            "input", LongList.of(),
            "output", List.of(1219070632396864L)
        ),
        // Testing output of very large number
        Map.of(
            "program", List.of(104L,1125899906842624L,99L),
            "input", LongList.of(),
            "output", List.of(1125899906842624L)
        ),
        // Testing output of very large number
        Map.of(
            "program", List.of(104L,1125899906842624L,99L),
            "input", LongList.of(),
            "output", List.of(1125899906842624L)
        )
    );

    @Test
    public void testRun() {
        testCases.forEach(test -> {
            var testIO = new TestIO(new ArrayList<>(test.get("input")));
            var machine = IntcodeMachine.withIO(testIO, new Intcode(test.get("program")));
            machine.run();

            assertEquals(test.get("output"), testIO.getOutput());
        });
    }
}
