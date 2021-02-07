package com.gcjensen.aoc2019.day7;

import com.gcjensen.aoc2019.Intcode.Intcode;
import com.gcjensen.aoc2019.Intcode.IntcodeMachine;

public class Amplifier {
    private final IntcodeMachine machine;

    public Amplifier() {
        this.machine = new IntcodeMachine();
    }

    public int runControllerSoftware(Intcode program, int inputSignal, int phaseSetting) {
        var io = new AmplifierIO(inputSignal, phaseSetting);
        this.machine.setIO(io);
        this.machine.loadProgram(program);
        this.machine.run();

        return io.getOutput().get(0);
    }
}
