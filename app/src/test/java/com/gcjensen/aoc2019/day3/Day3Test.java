package com.gcjensen.aoc2019.day3;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.gcjensen.aoc2019.Day;

public class Day3Test {
    Day<Wire> day3 = new Day3();

    private final List<Wire> testInput1 = List.of(
            Wire.parse("R8,U5,L5,D3"),
            Wire.parse("U7,R6,D4,L4")
    );
    private final List<Wire> testInput2 = List.of(
        Wire.parse("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"),
        Wire.parse("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")
    );
    private final List<Wire> actualInput = day3.parseInput();

    @Test public void testPart1() {
        assertEquals(6, day3.solvePart1(testInput1));
        assertEquals(135, day3.solvePart1(testInput2));
        assertEquals(627, day3.solvePart1(actualInput));
    }

    @Test public void testPart2() {
        assertEquals(30, day3.solvePart2(testInput1));
        assertEquals(410, day3.solvePart2(testInput2));
        assertEquals(13190, day3.solvePart2(actualInput));
    }
}
