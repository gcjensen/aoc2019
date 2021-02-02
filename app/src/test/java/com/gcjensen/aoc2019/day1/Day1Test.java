package com.gcjensen.aoc2019.day1;

import java.util.List;
import static org.junit.Assert.*;

import com.gcjensen.aoc2019.Day;
import org.junit.Test;

import com.gcjensen.aoc2019.day1.Day1;

public class Day1Test {
    Day<Integer> day1 = new Day1();

    private final List<Integer> testInput = List.of(1969, 100756);
    private final List<Integer> actualInput = day1.parseInput();

    @Test public void testPart1() {
        assertEquals(34237, day1.solvePart1(testInput));
        assertEquals(3412094, day1.solvePart1(actualInput));
    }

    @Test public void testPart2() {
        assertEquals(51312, day1.solvePart2(testInput));
        assertEquals(5115267, day1.solvePart2(actualInput));
    }
}
