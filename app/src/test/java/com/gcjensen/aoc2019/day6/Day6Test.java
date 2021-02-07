package com.gcjensen.aoc2019.day6;

import com.gcjensen.aoc2019.Day;
import com.gcjensen.aoc2019.day5.Day5;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day6Test {
    Day<Orbit> day6 = new Day6();

    private final List<Orbit> testInput = List.of(
        Orbit.parse("COM)B"),
        Orbit.parse("B)C"),
        Orbit.parse("C)D"),
        Orbit.parse("D)E"),
        Orbit.parse("E)F"),
        Orbit.parse("B)G"),
        Orbit.parse("G)H"),
        Orbit.parse("D)I"),
        Orbit.parse("E)J"),
        Orbit.parse("J)K"),
        Orbit.parse("K)L"),
        Orbit.parse("K)YOU"),
        Orbit.parse("I)SAN")
    );
    private final List<Orbit> actualInput = day6.parseInput();

    @Test public void testPart1() {
        assertEquals(54, day6.solvePart1(testInput));
        assertEquals(292387, day6.solvePart1(actualInput));
    }

    @Test public void testPart2() {
        assertEquals(4, day6.solvePart2(testInput));
        assertEquals(433, day6.solvePart2(actualInput));
    }
}
