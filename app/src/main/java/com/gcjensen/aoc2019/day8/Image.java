package com.gcjensen.aoc2019.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Image {
    private final List<Layer> layers;
    private final int width, height;

    public Image(List<Layer> layers, int width, int height) {
        this.layers = layers;
        this.width = width;
        this.height = height;
    }

    public static Image parse(List<Integer> data, Integer width, Integer height) {
        var numLayers = width * height;
        var layers = Layer.chunkUp(data, numLayers).stream()
            .map(l -> Layer.parse(l, width))
            .collect(Collectors.toList());

        return new Image(layers, width, height);
    }

    public Layer decode() {
        var combined = new ArrayList<Integer>();

        for (var y = 0; y < this.height; y++) {
            for (var x = 0; x < this.width; x++) {
                for (var layer : this.getLayers()) {
                    var pixel = layer.getPixel(x, y);
                    if (pixel != Layer.TRANSPARENT) {
                        combined.add(pixel);
                        break;
                    }
                }
            }
        }

        return Layer.parse(combined, this.width);
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

}

