package com.gcjensen.aoc2019.Intcode;

public class IntcodeMachine {
    private static final int OP_ADD = 1;
    private static final int OP_MUL = 2;
    private static final int OP_HALT = 99;

    private final Intcode memory;
    private int ptr = 0;

    public IntcodeMachine(Intcode program) {
        this.memory = program;
    }

    public Intcode run() {
        while (step());

        return this.memory;
    }

    private boolean step() {
        int opcode = this.memory.get(this.ptr);
        if (opcode == OP_HALT) {
            return false;
        }

        // Get the various addresses
        int op1Addr = this.memory.get(this.ptr + 1);
        int op2Addr = this.memory.get(this.ptr + 2);
        int resAddr = this.memory.get(this.ptr + 3);

        // Get the operands at the addresses
        int op1 = this.memory.get(op1Addr);
        int op2 = this.memory.get(op2Addr);

        switch (opcode) {
            case OP_ADD:
                this.memory.set(resAddr, op1 + op2);
                break;
            case OP_MUL:
                this.memory.set(resAddr, op1 * op2);
                break;
        }

        this.ptr += 4;
        return true;
    }
}
