package com.gcjensen.aoc2019.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Image {
    private final List<Layer> layers;

    public Image(List<Layer> layers) {
        this.layers = layers;
    }

    public static Image parse(List<Integer> data, Integer width, Integer height) {
        var numLayers = width * height;
        var layers = chunkUp(data, numLayers).stream()
            .map(l -> Layer.parse(l, width))
            .collect(Collectors.toList());

        return new Image(layers);
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public static class Layer {
        private final List<Integer> digits;
        private final List<List<Integer>> rows;

        public Layer(List<Integer> digits, List<List<Integer>> rows) {
            this.digits = digits;
            this.rows = rows;
        }

        public static Layer parse(List<Integer> digits, int width) {
            return new Layer(digits, new ArrayList<>(chunkUp(digits, width)));
        }

        public int digitCount(int digit) {
            return (int) this.digits.stream().filter(d -> d == digit).count();
        }
    }

    private static List<List<Integer>> chunkUp(List<Integer> digits, int size) {
        final AtomicInteger counter = new AtomicInteger();
        return new ArrayList<>(digits.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                .values());
    }
}

