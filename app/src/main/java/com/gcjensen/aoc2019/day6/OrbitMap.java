package com.gcjensen.aoc2019.day6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrbitMap {
    private final Map<String, SpaceObject> spaceObjects = new HashMap<>();

    public static OrbitMap fromData(List<Orbit> orbitData) {
        var map = new OrbitMap();

        for (var orbit : orbitData) {
            var parent = map.addParent(orbit.parent);
            var child = map.addChild(orbit.child, parent);
            parent.addChild(child);
        }

        return map;
    }

    public int computeOrbitCountChecksum() {
        var totalOrbits = 0;

        for (var spaceObj : this.spaceObjects.values()) {
            var orbitCount = 0;
            while (spaceObj.getParent() != null) {
                spaceObj = spaceObj.getParent();
                orbitCount++;
            }

            totalOrbits += orbitCount;
        }

        return totalOrbits;
    }

    public List<String> plotRoute(String from, String to) {
        if (!this.spaceObjects.containsKey(from) || !this.spaceObjects.containsKey(to)) {
            throw new IllegalArgumentException();
        }

        var fromSO = this.spaceObjects.get(from);
        var toSO = this.spaceObjects.get(to);

        return new OrbitalTransfers().findRoute(fromSO, toSO);
    }

    private SpaceObject addChild(String name, SpaceObject parent) {
        SpaceObject so;
        if (this.spaceObjects.containsKey(name)) {
            so = this.spaceObjects.get(name);
            so.setParent(parent);
            return so;
        }

        so = new SpaceObject(name, parent);
        this.spaceObjects.put(name, so);

        return so;
    }

    private SpaceObject addParent(String name) {
        if (this.spaceObjects.containsKey(name)) {
            return this.spaceObjects.get(name);
        }

        var so = new SpaceObject(name, null);
        this.spaceObjects.put(name, so);

        return so;
    }
}
