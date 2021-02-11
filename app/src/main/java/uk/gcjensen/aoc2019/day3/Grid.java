package uk.gcjensen.aoc2019.day3;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Grid {
    private final List<HashMap<Point, Integer>> paths = new ArrayList<>();

    public static Grid withWires(List<Wire> wires) {
        var grid = new Grid();
        for (var wire : wires) {
           grid.traceWire(wire);
        }

        return grid;
    }

    public HashMap<Point, Integer> getWireOverlaps() {
        var overlap = new HashMap<Point, Integer>();

        var firstWire = this.paths.get(0);
        for (var point : firstWire.keySet()) {
           for (var wire : this.paths.subList(1, this.paths.size())) {
               if (wire.containsKey(point)) {
                   var steps = wire.get(point);

                   if (overlap.containsKey(point)) {
                      overlap.put(point, overlap.get(point) + steps);
                      continue;
                   }

                   overlap.put(point, firstWire.get(point) + steps);
               }
           }
        }

        return overlap;
    }

    public static int distanceFromOrigin(Point point) {
        Double dis = Math.abs(point.getX()) + Math.abs(point.getY());
        return dis.intValue();
    }

    private void traceWire(Wire wire) {
        var path = new HashMap<Point, Integer>();

        int x = 0, y = 0, steps = 0;
        for (var move : wire.getMoves()) {
            for (var i = 0; i < move.getDistance(); i++) {
                var dir = move.getDirection();
                x += dir.getDX();
                y += dir.getDY();

                var point = new Point(x, y);
                steps++;

                // We only want to add the point the first time we see it
                if (!path.containsKey(point)) {
                    path.put(point, steps);
                }
            }
        }


        this.paths.add(path);
    }
}
