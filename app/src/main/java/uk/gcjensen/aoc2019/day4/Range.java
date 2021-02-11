package uk.gcjensen.aoc2019.day4;

public class Range {
    private final int min, max;

    public Range(int min, int max) {
        this.min = min;
        this.max= max;
    }

    public static Range parse(String range) {
        var minMax = range.split("-");
        return new Range(Integer.parseInt(minMax[0]), Integer.parseInt(minMax[1]));
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
