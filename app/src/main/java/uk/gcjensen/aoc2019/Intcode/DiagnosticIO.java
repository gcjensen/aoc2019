package uk.gcjensen.aoc2019.Intcode;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticIO implements IntcodeIO {
    private final List<Long> outputList = new ArrayList<>();
    private final long input;

    public DiagnosticIO(long input) {
        this.input = input;
    }

    @Override
    public void output(long val) {
        this.outputList.add(val);
    }

    @Override
    public Long input() {
        return this.input;
    }

    public List<Long> getOutput() {
        return this.outputList;
    }
}