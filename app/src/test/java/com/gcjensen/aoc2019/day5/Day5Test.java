package com.gcjensen.aoc2019.day5;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.gcjensen.aoc2019.Day;

public class Day5Test {
    Day<Long> day5 = new Day5();

    private final List<Long> actualInput = day5.parseInput();

    @Test public void testPart1() {
        assertEquals(10987514, day5.solvePart1(actualInput));
    }

    @Test public void testPart2() {
        assertEquals(14195011, day5.solvePart2(actualInput));
    }
}
