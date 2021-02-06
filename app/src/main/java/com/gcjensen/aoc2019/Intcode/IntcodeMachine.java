package com.gcjensen.aoc2019.Intcode;

public class IntcodeMachine {
    private final Intcode memory;

    private IntcodeIO io;
    private int ptr = 0;

    public IntcodeMachine(Intcode program) {
        this.memory = program;
    }

    public IntcodeMachine(Intcode program, IntcodeIO io) {
        this.memory = program;
        this.io = io;
    }

    public static IntcodeMachine withIO(IntcodeIO io, Intcode program) {
        return new IntcodeMachine(program, io);
    }

    public Intcode dumpMemory() {
        return this.memory;
    }

    public void run() {
        while (step());
    }

    /************ Private Implementation ************/

    private Parameter[] parseParameters(Intcode values) {
        var params = new Parameter[values.length()];

        // Divide by 100 as not all opcodes have explicit param modes. 0 is implied if omitted.
        var paramModes = this.memory.get(this.ptr) / 100;

        /*
         * For each parameter, pull a digit off the end of the paramModes (as they're essentially
         * in reverse).
         */
        for (var i = 0; i < values.length(); i++) {
            var mode = ParameterMode.from(paramModes % 10);
            paramModes /= 10;

            params[i] = new Parameter(this.memory.get(this.ptr + 1 + i), mode);
        }

        return params;
    }

    private int readMem(Parameter parameter) {
        return switch (parameter.mode()) {
            case POSITION -> this.memory.get(parameter.value());
            case IMMEDIATE -> parameter.value();
        };
    }

    private boolean step() {
        var opcode = Opcode.from(this.memory.get(this.ptr));
        if (opcode == Opcode.HALT) {
            return false;
        }

        var start = this.ptr + 1;
        var paramValues = this.memory.slice(start, start + opcode.getNumParameters());
        var params = this.parseParameters(paramValues);

        switch (opcode) {
            case ADD -> this.memory.set(params[2].value(), readMem(params[0]) + readMem(params[1]));
            case MUL -> this.memory.set(params[2].value(), readMem(params[0]) * readMem(params[1]));
            case IN -> this.memory.set(params[0].value(), this.io.input());
            case OUT -> this.io.output(readMem(params[0]));
        }

        this.ptr += opcode.getNumParameters() + 1;

        return true;
    }
}
