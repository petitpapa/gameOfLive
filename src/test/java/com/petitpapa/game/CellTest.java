package com.petitpapa.game;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by petitpapa
 * on 10/9/2016.
 */
public class CellTest {
    private Cell currentCell;

    @Test
    public void aliveCellWithFewerThanTwoLiveNeighboursDies(){
        currentCell = new Cell(Cell.State.ALIVE);
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        currentCell.updateState(neighbors);
        assertThat(currentCell.content(), is('.'));
    }

    @Test
    public void aliveCellWithTwoLiveNeighborsLives(){
        currentCell = new Cell(Cell.State.ALIVE);
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        currentCell.updateState(neighbors);
        assertThat(currentCell.content(), is('*'));
    }
    @Test
    public void aliveCellWithThreeLiveNeighborsLives(){
        currentCell = new Cell(Cell.State.ALIVE);
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.ALIVE));
        currentCell.updateState(neighbors);
        assertThat(currentCell.content(), is('*'));
    }
    @Test
    public void aliveCellWithMoreThanThreeLiveNeighborsDies(){
        currentCell = new Cell(Cell.State.ALIVE);
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.ALIVE));
        currentCell.updateState(neighbors);
        assertThat(currentCell.content(), is('.'));
    }
    @Test
    public void aDeadCellWithThreeLiveNeighborsLives(){
        currentCell = new Cell(Cell.State.DEAD);
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        neighbors.add(new Cell(Cell.State.ALIVE));
        neighbors.add(new Cell(Cell.State.DEAD));
        currentCell.updateState(neighbors);
        assertThat(currentCell.content(), is('*'));
    }
}
