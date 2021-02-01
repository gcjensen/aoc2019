package com.gcjensen.aoc2019;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public abstract class Day<T> {
    protected int day;

    public List<T> parseInput() {
        String filename = String.format("day%d.txt", this.day);
        InputStream stream = Day.class.getResourceAsStream(filename);
        return this.parseInput(new BufferedReader(new InputStreamReader(stream)).lines());
    }

    abstract public List<T> parseInput(Stream<String> input);

    abstract public Object solvePart1(List<T> input);
}
