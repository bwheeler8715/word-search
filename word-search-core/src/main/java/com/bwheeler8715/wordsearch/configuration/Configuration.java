package com.bwheeler8715.wordsearch.configuration;

import java.util.List;

/**
 * Immutable POJO representing a configuration for a word-search;
 */
public class Configuration {

    private Difficulty difficulty;
    private int gridSizeX;
    private int gridSizeY;
    private List<String> words;

    public Configuration(DifficultyEnum difficulty, int gridSizeX, int gridSizeY, List<String> words) {
        this.difficulty = new Difficulty(difficulty);
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
        this.words = words;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public int getGridSizeX() {
        return this.gridSizeX;
    }

    public int getGridSizeY() {
        return this.gridSizeY;
    }

    public List<String> getWords() {
        return this.words;
    }

    @Override
    public String toString() {
        return "Configuration{" +
            "difficulty=" + this.difficulty +
            ", gridSizeX=" + this.gridSizeX +
            ", gridSizeY=" + this.gridSizeY +
            ", word=" + this.words +
            '}';
    }
}
