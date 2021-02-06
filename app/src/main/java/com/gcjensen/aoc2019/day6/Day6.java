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
        return Map.fromData(input).computeOrbitCountChecksum();
    }

    @Override
    public Integer solvePart2(List<Orbit> input) {
        return null;
    }
}
