package com.gcjensen.aoc2019.day7;

import com.gcjensen.aoc2019.Day;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day7Test {
    Day<Integer> day7 = new Day7();

    private final List<Integer> testInput = new ArrayList<>(
        Arrays.asList(3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0)
    );
    private final List<Integer> actualInput = day7.parseInput();

    @Test public void testPart1() {
        assertEquals(54321, day7.solvePart1(testInput));
        assertEquals(277328, day7.solvePart1(actualInput));
    }
}
