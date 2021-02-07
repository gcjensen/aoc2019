package com.gcjensen.aoc2019.day7;

import com.gcjensen.aoc2019.Day;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day7Test {
    Day<Integer> day7 = new Day7();

    private final List<Integer> part1TestInput = List.of(
        3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0
    );
    private final List<Integer> part2TestInput = List.of(
        3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,
        53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10
    );

    private final List<Integer> actualInput = day7.parseInput();

    @Test public void testPart1() {
        assertEquals(54321, day7.solvePart1(part1TestInput));
        assertEquals(277328, day7.solvePart1(actualInput));
    }

    @Test public void testPart2() {
        assertEquals(18216, day7.solvePart2(part2TestInput));
        assertEquals(11304734, day7.solvePart2(actualInput));
    }
}
