package uk.gcjensen.aoc2019.day9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uk.gcjensen.aoc2019.Day;
import uk.gcjensen.aoc2019.Intcode.DiagnosticIO;
import uk.gcjensen.aoc2019.Intcode.Intcode;
import uk.gcjensen.aoc2019.Intcode.IntcodeMachine;

public class Day9 extends Day<Long> {
    private final int BOOST_TEST_MODE_INPUT = 1;

    public Day9() {
        super(9);
    }

    @Override
    public List<Long> parseInput(Stream<String> input) {
        String inputStr = input.findFirst().map(Object::toString).orElse(null);
        Stream<String> stream = Arrays.stream(inputStr.split(","));
        return stream.map(Long::parseLong).collect(Collectors.toList());
    }

    @Override
    public Long solvePart1(List<Long> input) {
        var diagIO = new DiagnosticIO(BOOST_TEST_MODE_INPUT);
        var machine = IntcodeMachine.withIO(diagIO, new Intcode(input));
        machine.run();

        var output = diagIO.getOutput();
        return output.get(diagIO.getOutput().size() - 1);
    }

    @Override
    public Integer solvePart2(List<Long> input) {
        return null;
    }
}

