package uk.gcjensen.aoc2019.day3;

public enum Direction {
    UP('U', 0, 1),
    DOWN('D', 0, -1),
    LEFT('L', -1, 0),
    RIGHT('R', 1, 0);

    private final char c;
    private final int dx;
    private final int dy;

    Direction(char c, int dx, int dy) {
        this.c = c;
        this.dx = dx;
        this.dy = dy;
    }

    public static Direction from(char c) {
        for (var dir : values()) {
            if (dir.c == c) {
                return dir;
            }
        }

        throw new IllegalArgumentException();
    }

    public int getDX() {
        return this.dx;
    }

    public int getDY() {
        return this.dy;
    }
}
