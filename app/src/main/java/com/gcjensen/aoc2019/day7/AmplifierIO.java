package com.gcjensen.aoc2019.day7;

import com.gcjensen.aoc2019.Intcode.IntcodeIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

public class AmplifierIO implements IntcodeIO {
    private final BlockingQueue<Integer> inputList, outputList;

    public AmplifierIO(BlockingQueue<Integer> inputList, BlockingQueue<Integer> outputList) {
        this.inputList = inputList;
        this.outputList = outputList;
    }

    @Override
    public void output(Integer val) {
        try {
            this.outputList.put(val);
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public Integer input() {
        try {
            return this.inputList.take();
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }
}