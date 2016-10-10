package com.petitpapa.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by petitpapa
 * on 10/9/2016.
 */
public class Grid {
    private final int rows;
    private final int cols;
    private Cell[][] grids;
    private int currentLine = 0;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grids = new Cell[rows][cols];
        initializeGrid();
    }

    private void initializeGrid() {
        int index = 0;
        for (; index < rows; index++) {
            addCells(grids[index]);
        }
    }

    private void addCells(Cell[] grid) {
        int i = 0;
        for (; i < cols; i++)
            grid[i] = new Cell(Cell.State.DEAD);
    }

    public void addRow(String lineOfCell) {
        char[] cells = lineOfCell.toCharArray();
        IntStream.range(0, cells.length).forEach(i -> {
            if (cells[i] == '*')
                getCell(currentLine, i).setState(Cell.State.ALIVE);
        });
        currentLine++;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(grids).map(rows -> appendCellContent(rows, sb)).forEach(e -> sb.append("\n"));
        return sb.toString();
    }

    private Cell[] appendCellContent(Cell[] rows, StringBuilder sb) {
        Arrays.stream(rows).forEach(e -> sb.append(e.content()));
        return  rows;
    }

    public void nextGeneration() {
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                List<Cell> neighbors = getNeighbors(i, j);
                getCell(i, j).updateState(neighbors);
            }
        }
    }

    private List<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<>();
        for(Direction direction : Direction.values()){
            if (new Range(rows, cols).isValid(row + direction.getX(),col + direction.getY() )) {
                neighbors.add(getCell(row + direction.getX(), col + direction.getY()));
            }
        }
        return neighbors;
    }

    private Cell getCell(int row, int col) {
        return grids[row][col];
    }

    public boolean hasLiveCell() {
       return Arrays.stream(grids).flatMap(rows -> Arrays.stream(rows)).filter(cell -> cell.content() == '*').count() > 0;
    }

    public void reset() {
        initializeGrid();
    }
}
