package com.petitpapa.game;

import java.util.List;

/**
 * Created by petitpapa
 * on 10/9/2016.
 */
public class Cell {

    public Cell(State state) {
        this.state = state;
    }

    public char content() {
        return state.content;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void updateState(List<Cell> neighbors) {
        int numberOfAliveNeighbors = countAliveNeighbors(neighbors);
        if (getState().equals(State.ALIVE)) {
            if (numberOfAliveNeighbors < 2)
                setState(State.DEAD);
            else if (numberOfAliveNeighbors == 2 || numberOfAliveNeighbors == 3)
                setState(state.ALIVE);
            else
                setState(State.DEAD);
        } else {
            if (numberOfAliveNeighbors == 3)
                setState(State.ALIVE);
            else
                setState(State.DEAD);
        }
    }

    private int countAliveNeighbors(List<Cell> neighbors) {
        return (int) neighbors.stream().filter(cell -> isAlive(cell)).count();
    }

    private boolean isAlive(Cell cell) {
        return cell.content() == State.ALIVE.content;
    }

    public enum State {
        ALIVE('*'), DEAD('.');
        private char content;

        State(char c) {
            this.content = c;
        }
    }

    ;

    public State getState() {
        return state;
    }

    private State state;
}
