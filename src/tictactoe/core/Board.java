package tictactoe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;

public class Board {
    public static final int SIZE = 3;

    private final Symbol[][] matrix = new Symbol[SIZE][SIZE];

    public Board() {
        for(Symbol[] symbols : matrix) {
            Arrays.fill(symbols, Symbol.NONE);
        }
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);

        for(int i = 0; i < SIZE; i++) {
            boolean first = true;
            for(int j = 0; j < SIZE; j++) {
                if(!first) {
                    out.print(" | ");
                }
                out.print(matrix[i][j]);
                first = false;
            }
            out.println();
        }

        return sw.toString();
    }

    public Symbol update(Symbol symbol, Coordinate coordinate) {
        Objects.requireNonNull(symbol);
        Objects.requireNonNull(coordinate);

        if(symbol == Symbol.NONE) {
            throw new IllegalArgumentException("None cannot be added to board");
        }

        if(matrix[coordinate.i()][coordinate.j()] != Symbol.NONE) {
            throw new IllegalArgumentException("Play is not possible");
        }

        matrix[coordinate.i()][coordinate.j()] = symbol;
        return findSequence();
    }

    private Symbol findSequence() {
        //TODO
        return null;
    }

    public boolean isFull() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(matrix[i][j] == Symbol.NONE) {
                    return false;
                }
            }
        }
        return true;
    }
}
