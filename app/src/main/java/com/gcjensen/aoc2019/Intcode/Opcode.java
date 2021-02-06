package com.gcjensen.aoc2019.Intcode;

public enum Opcode {
    ADD(1, 3),
    MUL(2, 3),
    IN(3, 1),
    OUT(4, 1),
    HALT(99, 0);

    private final int id, numParameters;

    Opcode(int id, int numParameters) {
        this.id = id;
        this.numParameters = numParameters;
    }

    public static Opcode from(Integer instruction) {
        // Some opcodes are proceeded by up to 3 parameters, so mod 100 will remove those
        var opcodeID = instruction % 100;
        for (var opcode : Opcode.values()) {
            if (opcode.id == opcodeID) {
                return opcode;
            }
        }

        throw new IllegalArgumentException();
    }

    public int getNumParameters() {
        return this.numParameters;
    }
}
