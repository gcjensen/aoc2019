package com.gcjensen.aoc2019.day6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;

public class Day6 extends Day<Orbit> {

    public Day6() {
        super(6);
    }

    @Override
    public List<Orbit> parseInput(Stream<String> input) {
        return input.map(Orbit::parse).collect(Collectors.toList());
    }

    public Integer solvePart1(List<Orbit> input) {
        return OrbitMap.fromData(input).computeOrbitCountChecksum();
    }

    @Override
    public Integer solvePart2(List<Orbit> input) {
        var map = OrbitMap.fromData(input);
        var route = map.plotRoute("YOU", "SAN");

        /*
         * Minus 3 because we're don't want to include the start and end objects, and we care about
         * the jumps between objects, rather than the number of objects.
         */
        return route.size() - 3;
    }
}
