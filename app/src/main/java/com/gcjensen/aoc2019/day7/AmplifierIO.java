package com.gcjensen.aoc2019.day7;

import com.gcjensen.aoc2019.Intcode.IntcodeIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AmplifierIO implements IntcodeIO {
    private final List<Integer> outputList = new ArrayList<>();
    private final Stack<Integer> inputs = new Stack<>();

    public AmplifierIO(int inputSignal, int phaseSetting) {
        this.inputs.add(inputSignal);
        this.inputs.add(phaseSetting);
    }

    @Override
    public void output(Integer val) {
        this.outputList.add(val);
    }

    @Override
    public Integer input() {
        return this.inputs.pop();
    }

    public List<Integer> getOutput() {
        return this.outputList;
    }
}