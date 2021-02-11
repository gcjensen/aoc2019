package uk.gcjensen.aoc2019.day1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uk.gcjensen.aoc2019.Day;

public class Day1 extends Day<Integer> {

    public Day1() {
        super(1);
    }

    @Override
    public List<Integer> parseInput(Stream<String> input) {
        return input.map(Integer::parseInt).collect(Collectors.toList());
    }

    public Integer solvePart1(List<Integer> input) {
        return input.stream().mapToInt(i -> this.calculateFuel(i, false)).sum();
    }

    @Override
    public Integer solvePart2(List<Integer> input) {
        return input.stream().mapToInt(i -> this.calculateFuel(i, true)).sum();
    }

    private Integer calculateFuel(Integer mass, boolean addFuelWeight) {
       int fuel = (int) Math.floor(mass.doubleValue() / 3) - 2;

       // Return early without recursing if we're not accounting for additional fuel weight
       if (!addFuelWeight) {
           return fuel;
       }

       if (fuel <= 0) {
           return 0;
       }

       return fuel + calculateFuel(fuel, true);
    }
}
