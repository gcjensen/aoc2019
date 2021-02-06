package com.gcjensen.aoc2019.Intcode;

public enum ParameterMode {
    POSITION(0),
    IMMEDIATE(1);

    private final int id;

    public static ParameterMode from(int id) {
        for (var mode : values()) {
            if (mode.id == id) {
                return mode;
            }
        }

        throw new IllegalArgumentException();
    }

    ParameterMode(int id) {
        this.id = id;
    }
}
