package com.petitpapa.game;

/**
 * Created
 * by petitpapa on 10/9/2016.
 */
public enum Direction {
    NW(-1, 1), N(0, 1), NE(1, 1),
    E(1, 0),
    SE(1,-1), S(0, -1), SW(-1,-1),
    W(-1, 0);

    private final int x;
    private final int y;
    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
