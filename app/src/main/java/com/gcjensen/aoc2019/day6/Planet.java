package com.gcjensen.aoc2019.day6;

public class Planet {
    private final String name;
    private Planet parent;

    public Planet(String name, Planet parent) {
        this.name = name;
        this.parent = parent;
    }

    public Planet getParent() {
        return this.parent;
    }

    public void setParent(Planet planet) {
       this.parent = planet;
    }

    @Override
    public String toString() {
        var parent = this.parent != null ? this.parent.name : "NONE";
        return String.format("%s)%s", parent, this.name);
    }
}
