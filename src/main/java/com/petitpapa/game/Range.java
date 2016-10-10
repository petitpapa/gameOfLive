package com.petitpapa.game;

/**
 * Created by petitpapa
 * on 10/9/2016.
 */
public class Range {
    private final int numberOfRows;
    private final int numberOfCols;

    public Range(int start, int end) {
        this.numberOfRows = start;
        this.numberOfCols = end;
    }

    public boolean isValid(int row, int col) {
        return  (row >= 0 && row < numberOfRows) && (col >= 0 && col < numberOfCols);
    }
}
