package com.gcjensen.aoc2019.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gcjensen.aoc2019.LongList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.gcjensen.aoc2019.Day;

public class Day2Test {
    Day<Long> day2 = new Day2();

    private final List<Long> testInput = LongList.of(1, 3, 1, 2, 99, 1, 2, 3, 1, 3, 4, 3, 1);
    private final List<Long> actualInput = day2.parseInput();

    @Test public void testPart1() {
        assertEquals(1, day2.solvePart1(testInput));
        assertEquals(5866714, day2.solvePart1(actualInput));
    }

    @Test public void testPart2() {
        assertEquals(5208, day2.solvePart2(actualInput));
    }
}
