package com.gcjensen.aoc2019.day8;

import com.gcjensen.aoc2019.Day;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day8 extends Day<Integer> {
    public Day8() {
        super(8);
    }

    @Override
    public List<Integer> parseInput(Stream<String> input) {
        String inputStr = input.findFirst().map(Object::toString).orElse(null);
        assert inputStr != null;

        return inputStr.chars().map(c -> c-'0').boxed().collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<Integer> input) {
        int width = 25, height = 6;

        var layer = Image.parse(input, width, height).getLayers().stream()
            .min(Comparator.comparing(l -> l.digitCount(0)))
            .orElseThrow();

        return layer.digitCount(1) * layer.digitCount(2);
    }

    @Override
    public Long solvePart2(List<Integer> input) {
        return null;
    }
}

