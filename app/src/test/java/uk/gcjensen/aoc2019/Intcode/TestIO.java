package uk.gcjensen.aoc2019.Intcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestIO implements IntcodeIO {
    private final Stack<Long> inputList = new Stack<>();
    private final List<Long> outputList = new ArrayList<>();

    public TestIO(List<Long> input) {
        this.inputList.addAll(input);
    }

    @Override
    public void output(long val) {
       this.outputList.add(val);
    }

    @Override
    public Long input() {
        return this.inputList.pop();
    }

    public List<Long> getOutput() {
       return this.outputList;
    }
}
