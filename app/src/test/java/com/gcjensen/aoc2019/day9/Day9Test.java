package com.gcjensen.aoc2019.day9;

import com.gcjensen.aoc2019.Day;
import com.gcjensen.aoc2019.day8.Day8;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day9Test {
    Day<Long> day9 = new Day9();

    private final List<Long> actualInput = day9.parseInput();

    @Test public void testPart1() {
        assertEquals(3409270027L, day9.solvePart1(actualInput));
    }

}
