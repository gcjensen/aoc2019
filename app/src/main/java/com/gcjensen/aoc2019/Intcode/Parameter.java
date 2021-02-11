package com.gcjensen.aoc2019.Intcode;

public class Parameter {
    private final long value;
    private final ParameterMode mode;

    public Parameter(long value, ParameterMode mode) {
        this.value = value;
        this.mode = mode;
    }

    public ParameterMode mode() {
        return this.mode;
    }

    public long value() {
        return this.value;
    }
}
