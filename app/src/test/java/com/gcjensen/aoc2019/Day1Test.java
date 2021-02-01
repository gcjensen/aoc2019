package com.gcjensen.aoc2019;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

import com.gcjensen.aoc2019.day1.Day1;

public class Day1Test {
    Day<Integer> day1 = new Day1();

    private final List<Integer> testInput = List.of(1, 3, 20, 6);
    private final List<Integer> actualInput = day1.parseInput();

    @Test public void testPart1() {
        assertEquals(1, day1.solvePart1(testInput));
        assertEquals(3412094, day1.solvePart1(actualInput));
    }
}
