package uk.gcjensen.aoc2019.day6;

public class Orbit {
    public final String parent;
    public final String child;

    public Orbit(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }

    public static Orbit parse(String orbit) {
        var parts = orbit.split("\\)");

        return new Orbit(parts[0], parts[1]);
    }
}
