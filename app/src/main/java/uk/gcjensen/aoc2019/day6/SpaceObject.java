package uk.gcjensen.aoc2019.day6;

import java.util.ArrayList;
import java.util.List;

public class SpaceObject {
    private final String name;
    private SpaceObject parent;
    private List<SpaceObject> children = new ArrayList<>();

    public SpaceObject(String name, SpaceObject parent) {
        this.name = name;
        this.parent = parent;
    }

    public boolean addChild(SpaceObject child) {
        return this.children.add(child);
    }

    public SpaceObject getParent() {
        return this.parent;
    }

    public void setParent(SpaceObject planet) {
       this.parent = planet;
    }

    public List<SpaceObject> getChildren() {
        return this.children;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        var parent = this.parent != null ? this.parent.name : "NONE";
        return String.format("%s)%s", parent, this.name);
    }
}
