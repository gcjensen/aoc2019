package com.gcjensen.aoc2019.Intcode;

public class Parameter {
    private final int value;
    private final ParameterMode mode;

    public Parameter(int value, ParameterMode mode) {
        this.value = value;
        this.mode = mode;
    }

    public ParameterMode mode() {
        return mode;
    }

    public int value() {
        return value;
    }
}
