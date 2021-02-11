package uk.gcjensen.aoc2019;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongList {
    public static List<Long> of(int... i) {
        return Arrays.stream(i).mapToLong(l -> l).boxed().collect(Collectors.toList());
    }
}
