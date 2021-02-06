package com.gcjensen.aoc2019.day5;

import java.util.ArrayList;
import java.util.List;

import com.gcjensen.aoc2019.Intcode.IntcodeIO;

public class DiagnosticIO implements IntcodeIO {
    private final List<Integer> outputList = new ArrayList<>();
    private final int input;

    public DiagnosticIO(int input) {
        this.input = input;
    }

    @Override
    public void output(Integer val) {
        this.outputList.add(val);
    }

    @Override
    public Integer input() {
        return this.input;
    }

    public List<Integer> getOutput() {
        return this.outputList;
    }
}