package uk.gcjensen.aoc2019.Intcode;

public class IntcodeMachine {
    private final Intcode memory;
    private IntcodeIO io;

    private long ptr = 0, relativeBase = 0;

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
        this.ptr = 0;
        while (step());
    }

    /************ Private Implementation ************/

    private Parameter[] parseParameters(Intcode values) {
        var params = new Parameter[values.size()];

        // Divide by 100 as not all opcodes have explicit param modes. 0 is implied if omitted.
        var paramModes = this.memory.read(this.ptr) / 100;

        /*
         * For each parameter, pull a digit off the end of the paramModes (as they're essentially
         * in reverse).
         */
        for (var i = 0; i < values.size(); i++) {
            var mode = ParameterMode.from(paramModes % 10);
            paramModes /= 10;

            params[i] = new Parameter(this.memory.read(this.ptr + 1 + i), mode);
        }

        return params;
    }

    private long readMem(Parameter parameter) {
        return switch (parameter.mode()) {
            case POSITION -> this.memory.read(parameter.value());
            case IMMEDIATE -> parameter.value();
            case RELATIVE -> this.memory.read(parameter.value() + this.relativeBase);
        };
    }

    private boolean step() {
        var opcode = Opcode.from(this.memory.read((int) this.ptr));
        if (opcode == Opcode.HALT) {
            return false;
        }

        var start = (int) (this.ptr + 1);
        var paramValues = this.memory.slice(start, start + opcode.getNumParameters());
        var params = this.parseParameters(paramValues);

        switch (opcode) {
            case ADD -> this.writeMem(params[2], readMem(params[0]) + readMem(params[1]));
            case MUL -> this.writeMem(params[2], readMem(params[0]) * readMem(params[1]));
            case IN -> this.writeMem(params[0], this.io.input());
            case OUT -> this.io.output(readMem(params[0]));
            case JUMP_TRUE -> {
                if (readMem(params[0]) != 0) {
                    this.ptr = (int) readMem(params[1]);
                    return true;
                }
            }
            case JUMP_FALSE -> {
                if (readMem(params[0]) == 0) {
                    this.ptr = (int) readMem(params[1]);
                    return true;
                }
            }
            case LESS_THAN -> {
                var result = readMem(params[0]) < readMem((params[1])) ? 1L : 0L;
                this.writeMem(params[2], result);
            }
            case EQUAL -> {
                var result = readMem(params[0]) == readMem((params[1])) ? 1L : 0L;
                this.writeMem(params[2], result);
            }
            case ADJ_BASE -> this.relativeBase += readMem(params[0]);
        }

        this.ptr += opcode.getNumParameters() + 1;

        return true;
    }

    private void writeMem(Parameter parameter, long value) {
        switch (parameter.mode()) {
            case POSITION -> this.memory.write(parameter.value(), value);
            case IMMEDIATE -> throw new IllegalArgumentException();
            case RELATIVE -> this.memory.write(parameter.value() + this.relativeBase, value);
        };
    }
}
