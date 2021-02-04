package com.gcjensen.aoc2019.day3;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Grid {
    private final List<Set<Point>> paths = new ArrayList<>();

    public static Grid withWires(List<Wire> wires) {
        var grid = new Grid();
        for (var wire : wires) {
           grid.traceWire(wire);
        }

        return grid;
    }

    public Set<Point> getWireOverlaps() {
        var overlap = this.paths.get(0);
        this.paths.subList(1, this.paths.size()).forEach(overlap::retainAll);

        return overlap;
    }

    public static int distanceFromOrigin(Point point) {
        Double dis = Math.abs(point.getX()) + Math.abs(point.getY());
        return dis.intValue();
    }

    private void traceWire(Wire wire) {
        var path = new HashSet<Point>();

        int x = 0, y = 0;
        for (var move : wire.getMoves()) {
            for (var i = 0; i < move.getDistance(); i++) {
                var dir = move.getDirection();
                x += dir.getDX();
                y += dir.getDY();

                path.add(new Point(x, y));
            }
        }

        this.paths.add(path);
    }
}
