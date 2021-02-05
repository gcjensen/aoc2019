package com.gcjensen.aoc2019.day4;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;

public class Day4 extends Day<Range> {

    public Day4() {
        super(4);
    }

    @Override
    public List<Range> parseInput(Stream<String> input) {
        return input.map(Range::parse).collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<Range> input) {
        List<IntPredicate> rules = List.of(Rules::repetition, Rules::increasingDigits);
        return NumberGenerator.generate(input.get(0), rules).size();
    }

    @Override
    public Integer solvePart2(List<Range> input) {
        List<IntPredicate> rules = List.of(Rules::repetition2xOnly, Rules::increasingDigits);
        return NumberGenerator.generate(input.get(0), rules).size();
    }
}
