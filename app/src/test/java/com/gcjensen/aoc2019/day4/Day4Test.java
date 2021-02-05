package com.gcjensen.aoc2019.day4;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.gcjensen.aoc2019.Day;

public class Day4Test {
    Day<Range> day4 = new Day4();

    private final List<Range> testInput = List.of(Range.parse("220-240"));
    private final List<Range> actualInput = day4.parseInput();

    @Test public void testPart1() {
        assertEquals(9, day4.solvePart1(testInput));
        assertEquals(1767, day4.solvePart1(actualInput));
    }
}
