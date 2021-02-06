package com.gcjensen.aoc2019.day6;

import java.util.HashMap;
import java.util.List;

public class Map {
    public HashMap<String, Planet> planets = new HashMap<>();

    public static Map fromData(List<Orbit> orbitData) {
        var map = new Map();

        for (var orbit : orbitData) {
            var parent = map.addParent(orbit.parent);
            map.addChild(orbit.child, parent);
        }

        return map;
    }

    public int computeOrbitCountChecksum() {
        var totalOrbits = 0;

        for (var planet : this.planets.values()) {
            var orbitCount = 0;
            while (planet.getParent() != null) {
                planet = planet.getParent();
                orbitCount++;
            }

            totalOrbits += orbitCount;
        }

        return totalOrbits;
    }

    private void addChild(String name, Planet parent) {
        Planet planet;
        if (this.planets.containsKey(name)) {
            planet = this.planets.get(name);
            planet.setParent(parent);
            return;
        }

        planet = new Planet(name, parent);
        this.planets.put(name, planet);
    }

    private Planet addParent(String name) {
        if (this.planets.containsKey(name)) {
            return this.planets.get(name);
        }

        var planet = new Planet(name, null);
        this.planets.put(name, planet);
        return planet;
    }
}
