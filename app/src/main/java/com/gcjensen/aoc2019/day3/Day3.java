package com.gcjensen.aoc2019.day3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;

public class Day3 extends Day<String> {
    public Day3() {
        super(3);
    }

    @Override
    public List<String> parseInput(Stream<String> input) {
        return input.collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<String> input) {
        var wires = input.stream().map(Wire::parse).collect(Collectors.toList());

        return Grid.withWires(wires).getWireOverlaps().stream()
            .map(Grid::distanceFromOrigin)
            .min(Integer::compareTo)
            .orElseThrow();
    }


    @Override
    public Integer solvePart2(List<String> input) {
        return null;
    }
}

