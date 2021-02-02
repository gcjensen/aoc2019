package com.gcjensen.aoc2019.Intcode;

public class IntcodeMachine {
    private static final int OP_ADD = 1;
    private static final int OP_MUL = 2;
    private static final int OP_HALT = 99;

    private final Intcode instructions;
    private int pos = 0;

    public IntcodeMachine(Intcode instructions) {
        this.instructions = instructions;
    }

    public Intcode run() {
        while (step());

        return this.instructions;
    }

    private boolean step() {
        int opcode = this.instructions.get(this.pos);
        if (opcode == OP_HALT) {
            return false;
        }

        int pos1 = this.instructions.get(this.pos + 1);
        int pos2 = this.instructions.get(this.pos + 2);
        int resPos = this.instructions.get(this.pos + 3);

        int op1 = this.instructions.get(pos1);
        int op2 = this.instructions.get(pos2);

        switch (opcode) {
            case OP_ADD:
                this.instructions.set(resPos, op1 + op2);
                break;
            case OP_MUL:
                this.instructions.set(resPos, op1 * op2);
                break;
        }

        this.pos += 4;
        return true;
    }
}
