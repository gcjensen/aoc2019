package com.gcjensen.aoc2019.day1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;

public class Day1 extends Day<Integer> {

    public Day1() {
        this.day = 1;
    }

    @Override
    public List<Integer> parseInput(Stream<String> input) {
        return input.map(Integer::parseInt).collect(Collectors.toList());
    }

    public Integer solvePart1(List<Integer> input) {
        return input.stream().mapToInt(m -> (int) (Math.floor(m.doubleValue() / 3) - 2)).sum();
    }
}
