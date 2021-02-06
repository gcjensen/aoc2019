package com.gcjensen.aoc2019.Intcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestIO implements IntcodeIO {
    private final Stack<Integer> inputList = new Stack<>();
    private final List<Integer> outputList = new ArrayList<>();

    public TestIO(List<Integer> input) {
        this.inputList.addAll(input);
    }

    @Override
    public void output(Integer val) {
       this.outputList.add(val);
    }

    @Override
    public Integer input() {
        return this.inputList.pop();
    }

    public List<Integer> getOutput() {
       return this.outputList;
    }
}
