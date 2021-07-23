package com.bwheeler8715.wordsearch.generator.grid;

/**
 * POJO representing the word-search grid.
 */
public class Grid {

    private char[][] grid;

    public Grid(int sizeX, int sizeY) {
        this.grid = new char[sizeX][sizeY];
    }

    public char[][] getGrid() {
        return this.grid;
    }

    public void addCharAtCoordinate(char charToAdd, Coordinate coordinate) {
        this.grid[coordinate.getY()][coordinate.getX()] = charToAdd;
    }

    public char getCharAtCoordinate(Coordinate coordinate) {
        return this.grid[coordinate.getY()][coordinate.getX()];
    }
}
