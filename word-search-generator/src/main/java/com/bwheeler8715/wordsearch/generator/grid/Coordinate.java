package com.bwheeler8715.wordsearch.generator.grid;

/**
 * POJO representing a coordinate on the word-search grid.
 */
public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void incrementX() {
        this.x++;
    }

    public void decrementX() {
        this.x--;
    }

    public int getY() {
        return this.y;
    }

    public void incrementY() {
        this.y++;
    }

    public void decrementY() {
        this.y--;
    }
}
