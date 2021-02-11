package uk.gcjensen.aoc2019.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uk.gcjensen.aoc2019.Day;
import uk.gcjensen.aoc2019.Intcode.DiagnosticIO;
import uk.gcjensen.aoc2019.Intcode.Intcode;
import uk.gcjensen.aoc2019.Intcode.IntcodeMachine;

public class Day5 extends Day<Long> {
    private final int AIR_CON_ID = 1;
    private final int THERMAL_RADIATOR_ID = 5;

    public Day5() {
        super(5);
    }

    @Override
    public List<Long> parseInput(Stream<String> input) {
        String inputStr = input.findFirst().map(Object::toString).orElse(null);
        Stream<String> stream = Arrays.stream(inputStr.split(","));
        return stream.map(Long::parseLong).collect(Collectors.toList());
    }

    @Override
    public Integer solvePart1(List<Long> input) {
        var diagIO = new DiagnosticIO(AIR_CON_ID);
        var machine = IntcodeMachine.withIO(diagIO, new Intcode(input));
        machine.run();

        var output = diagIO.getOutput();
        return output.get(output.size() - 1).intValue();
    }

    @Override
    public Integer solvePart2(List<Long> input) {
        var diagIO = new DiagnosticIO(THERMAL_RADIATOR_ID);
        var machine = IntcodeMachine.withIO(diagIO, new Intcode(input));
        machine.run();

        return diagIO.getOutput().get(0).intValue();
    }
}

