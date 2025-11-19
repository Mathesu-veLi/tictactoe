package tictactoe.core;

import tictactoe.util.ValidationUtils;

import java.util.Objects;

import static tictactoe.core.Board.SIZE;

public record Coordinate(int i, int j) {
    public Coordinate {
        ValidationUtils.require(i >= 0 && i < SIZE, "i is out of range");
        ValidationUtils.require(j >= 0 && j < SIZE, "j is out of range");
    }

    public static Coordinate parse(String text) {
        Objects.requireNonNull(text);
        String[] tokens = text.split(",");

        if (tokens.length != 2) throw new IllegalArgumentException("Invalid format");

        try {
            return new Coordinate(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number");
        }
    }
}
