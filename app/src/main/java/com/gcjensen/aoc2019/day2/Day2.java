package com.gcjensen.aoc2019.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;
import com.gcjensen.aoc2019.Intcode.Intcode;
import com.gcjensen.aoc2019.Intcode.IntcodeMachine;

public class Day2 extends Day<Integer> {
    private static final int OUTPUT_ADDR = 0;
    private static final int NOUN_ADDR = 1;
    private static final int VERB_ADDR = 2;

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
        var machine = new IntcodeMachine(ic);
        machine.run();
        return machine.dumpMemory().get(0);
    }

    @Override
    public Integer solvePart2(List<Integer> input) {
        final int minVal = 0;
        final int maxVal = 99;
        final int targetVal = 19690720;

        for (int noun = minVal; noun <= maxVal; noun++) {
            for (int verb = minVal; verb <= maxVal; verb++) {
                Intcode ic = new Intcode(input);
                ic.set(NOUN_ADDR, noun);
                ic.set(VERB_ADDR, verb);

                var machine = new IntcodeMachine(ic);
                machine.run();
                if (machine.dumpMemory().get(OUTPUT_ADDR) == targetVal) {
                    return 100 * noun + verb;
                }
            }
        }

        return null;
    }

    private Intcode restoreGravityAssistProgram(Intcode ic) {
       ic.set(1, 12);
       ic.set(2, 2);

       return ic;
    }

}

