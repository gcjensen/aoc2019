package com.gcjensen.aoc2019.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gcjensen.aoc2019.Day;
import com.gcjensen.aoc2019.Intcode.Intcode;
import com.gcjensen.aoc2019.Intcode.IntcodeMachine;

public class Day2 extends Day<Long> {
    private static final int OUTPUT_ADDR = 0;
    private static final int NOUN_ADDR = 1;
    private static final int VERB_ADDR = 2;

    public Day2() {
        super(2);
    }

    @Override
    public List<Long> parseInput(Stream<String> input) {
        String inputStr = input.findFirst().map(Object::toString).orElse(null);
        Stream<String> stream = Arrays.stream(inputStr.split(","));
        return stream.map(Long::parseLong).collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<Long> input) {
        Intcode ic = this.restoreGravityAssistProgram(new Intcode(input));
        var machine = new IntcodeMachine(ic);
        machine.run();
        return (int) machine.dumpMemory().read(0);
    }

    @Override
    public Integer solvePart2(List<Long> input) {
        final int minVal = 0;
        final int maxVal = 99;
        final int targetVal = 19690720;

        for (var noun = minVal; noun <= maxVal; noun++) {
            for (var verb = minVal; verb <= maxVal; verb++) {
                Intcode ic = new Intcode(input);
                ic.write(NOUN_ADDR, (long) noun);
                ic.write(VERB_ADDR, (long) verb);

                var machine = new IntcodeMachine(ic);
                machine.run();
                if (machine.dumpMemory().read(OUTPUT_ADDR) == targetVal) {
                    return 100 * noun + verb;
                }
            }
        }

        return null;
    }

    private Intcode restoreGravityAssistProgram(Intcode ic) {
       ic.write(1, 12L);
       ic.write(2, 2L);

       return ic;
    }

}

