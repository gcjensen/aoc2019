package com.gcjensen.aoc2019.Intcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Intcode {
    private final List<Long> intcode;

    public Intcode(List<Long> intcode) {
        this.intcode = new ArrayList<>(intcode);
    }

    public static Intcode of(int... i) {
        return new Intcode(Arrays.stream(i).mapToLong(l -> l).boxed().collect(Collectors.toList()));
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

    public long read(long address) {
        return address >= this.intcode.size() ? 0 : this.intcode.get((int) address);
    }

    public int size() {
        return this.intcode.size();
    }

    public void write(long address, long val) {
        // If the address it outside the program memory then expand it
        if (address >= this.intcode.size()) {
            this.expand(address - this.intcode.size());
        }

        this.intcode.set((int) address, val);
    }

    public Intcode slice(int start, int end) {
        return new Intcode(this.intcode.subList(start, end));
    }

    /************ Private Implementation ************/

    private void expand(long size) {
        var padding = Collections.nCopies((int) size + 1, 0L).stream()
            .mapToLong(i -> i).boxed().collect(Collectors.toList());
        this.intcode.addAll(padding);
    }
}
