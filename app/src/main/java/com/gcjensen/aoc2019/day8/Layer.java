package com.gcjensen.aoc2019.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Layer {
    public static final int WHITE = 1;
    public static final int TRANSPARENT = 2;

    private final List<Integer> digits;
    private final List<List<Integer>> rows;

    public Layer(List<Integer> digits, List<List<Integer>> rows) {
        this.digits = digits;
        this.rows = rows;
    }

    public static Layer parse(List<Integer> digits, int width) {
        return new Layer(digits, new ArrayList<>(chunkUp(digits, width)));
    }

    public static List<List<Integer>> chunkUp(List<Integer> digits, int size) {
        final AtomicInteger counter = new AtomicInteger();
        return new ArrayList<>(digits.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                .values());
    }

    public int digitCount(int digit) {
        return (int) this.digits.stream().filter(d -> d == digit).count();
    }

    public String draw() {
        var str = new StringBuilder();

        for (var row : this.rows) {
            for (var pixel : row) {
                str.append(pixel == WHITE ? "0" : " ");
            }
            str.append("\n");
        }

        return str.toString();
    }

    public int getPixel(int x, int y) {
        return this.rows.get(y).get(x);
    }
}
