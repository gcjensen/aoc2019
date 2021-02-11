package uk.gcjensen.aoc2019.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Wire {
    public List<Move> moves;

    public static Wire parse(String moves) {
        return new Wire(Arrays.stream(moves.split(","))
            .map(Move::parse)
            .collect(Collectors.toList()));
    }

    public Wire(List<Move> moves) {
        this.moves = moves;
    }

    public List<Move> getMoves() {
        return this.moves;
    }
}
