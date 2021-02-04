package com.gcjensen.aoc2019.day3;

public class Move {
    private final Direction dir;
    private final int distance;

    public Move(Direction dir, int distance) {
        this.dir = dir;
        this.distance = distance;
    }

    public static Move parse(String move) {
        var dir = Direction.from(move.charAt(0));
        var distance = Integer.parseInt(move.substring(1));
        return new Move(dir, distance);
    }

    public Direction getDirection() {
        return this.dir;
    }

    public int getDistance() {
        return this.distance;
    }
}
