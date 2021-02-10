package com.gcjensen.aoc2019.day8;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.gcjensen.aoc2019.Day;

public class Day8Test {
    Day<Integer> day8 = new Day8();

    private final List<Integer> actualInput = day8.parseInput();

    @Test public void testPart1() {
        assertEquals(1920, day8.solvePart1(actualInput));
    }
}
