package com.gcjensen.aoc2019;

import java.util.List;

import com.gcjensen.aoc2019.day1.Day1;
import com.gcjensen.aoc2019.day2.Day2;
import com.gcjensen.aoc2019.day3.Day3;
import com.gcjensen.aoc2019.day4.Day4;
import com.gcjensen.aoc2019.day5.Day5;
import com.gcjensen.aoc2019.day6.Day6;
import com.gcjensen.aoc2019.day7.Day7;
import com.gcjensen.aoc2019.day8.Day8;

public class Aoc {
    public static void main(String[] args) {
        List<Day> days = List.of(
            new Day1(),
            new Day2(),
            new Day3(),
            new Day4(),
            new Day5(),
            new Day6(),
            new Day7(),
            new Day8()
        );

        days.forEach(day -> {
            List input = day.parseInput();
            System.out.printf(
                "Day %d\n\s\sPart 1: %s\n\s\sPart 2: %s\n",
                day.day,
                day.solvePart1(input),
                day.solvePart2(input)
            );
        });
    }
}
