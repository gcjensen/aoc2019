package com.gcjensen.aoc2019.day7;

import com.gcjensen.aoc2019.Day;
import com.gcjensen.aoc2019.Intcode.Intcode;

import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day7 extends Day<Integer> {
    private final List<Integer> PHASE_SETTINGS = List.of(0, 1, 2, 3, 4);

    public Day7() {
        super(7);
    }

    @Override
    public List<Integer> parseInput(Stream<String> input) {
        String inputStr = input.findFirst().map(Object::toString).orElse(null);
        Stream<String> stream = Arrays.stream(inputStr.split(","));
        return stream.map(Integer::parseInt).collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<Integer> input) {
        return Collections2.permutations(this.PHASE_SETTINGS).stream()
            .mapToInt(settings -> this.runWithPhaseSettings(new Intcode(input), settings))
            .max()
            .orElseThrow();
    }

    @Override
    public Integer solvePart2(List<Integer> input) {
        return null;
    }

    private int runWithPhaseSettings(Intcode program, List<Integer> settings) {
        var amplifier = new Amplifier();

        var output = 0;
        for (var setting : settings) {
            output = amplifier.runControllerSoftware(program, output, setting);
        }

        return output;
    }

}

