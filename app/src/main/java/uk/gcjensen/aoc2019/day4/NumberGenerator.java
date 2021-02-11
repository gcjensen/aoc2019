package uk.gcjensen.aoc2019.day4;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {
    public static List<Integer> generate(Range range, List<IntPredicate> rules) {
        return IntStream.rangeClosed(range.getMin(), range.getMax())
            .boxed()
            .filter(i -> {
                for (var rule : rules) {
                    if (!rule.test(i)) {
                        return false;
                    }
                }
                return true;
            })
            .collect(Collectors.toList());
    }
}
