package com.gcjensen.aoc2019.Intcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intcode {
    private final List<Integer> intcode;

    public Intcode(List<Integer> intcode) {
       this.intcode = new ArrayList<>(intcode);
    }

    public static Intcode of(Integer... i) {
        return new Intcode(new ArrayList<>(Arrays.asList(i)));
    }

    @Override
    public String toString() {
       return this.intcode.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) {
            return false;
        }

        return this.intcode.equals(((Intcode) o).intcode);
    }

    public Integer get(int pos) {
        return this.intcode.get(pos);
    }

    public void set(int pos, int val) {
        this.intcode.set(pos, val);
    }

}
