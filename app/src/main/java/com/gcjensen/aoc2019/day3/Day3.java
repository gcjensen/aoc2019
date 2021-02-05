package com.gcjensen.aoc2019.day3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;

public class Day3 extends Day<Wire> {
    public Day3() {
        super(3);
    }

    @Override
    public List<Wire> parseInput(Stream<String> input) {
        return input.map(Wire::parse).collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<Wire> wires) {
        return Grid.withWires(wires).getWireOverlaps().keySet().stream()
            .map(Grid::distanceFromOrigin)
            .min(Integer::compareTo)
            .orElseThrow();
    }

    @Override
    public Integer solvePart2(List<Wire> wires) {
        return Grid.withWires(wires).getWireOverlaps().values().stream()
            .min(Integer::compareTo)
            .orElseThrow();
    }
}

