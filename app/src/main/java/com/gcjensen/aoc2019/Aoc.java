package com.gcjensen.aoc2019;

import java.util.List;

import com.gcjensen.aoc2019.day1.Day1;

public class Aoc {
    public static void main(String[] args) {
        List<Day> days = List.of(new Day1());

        days.forEach(day -> {
            List input = day.parseInput();
            System.out.println(day.solvePart1(input));
        });
    }
}
