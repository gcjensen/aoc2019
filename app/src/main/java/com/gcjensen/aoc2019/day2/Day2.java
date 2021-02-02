package com.gcjensen.aoc2019.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;
import com.gcjensen.aoc2019.Intcode.Intcode;
import com.gcjensen.aoc2019.Intcode.IntcodeMachine;

public class Day2 extends Day<Integer> {
    public Day2() {
        super(2);
    }

    @Override
    public List<Integer> parseInput(Stream<String> input) {
        String inputStr = input.findFirst().map(Object::toString).orElse(null);
        Stream<String> stream = Arrays.stream(inputStr.split(","));
        return stream.map(Integer::parseInt).collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<Integer> input) {
        Intcode ic = this.restoreGravityAssistProgram(new Intcode(input));
        Intcode output = new IntcodeMachine(ic).run();
        return output.get(0);
    }

    @Override
    public Integer solvePart2(List<Integer> input) {
        return null;
    }

    private Intcode restoreGravityAssistProgram(Intcode ic) {
       ic.set(1, 12);
       ic.set(2, 2);

       return ic;
    }

}

