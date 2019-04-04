package com.bwheeler8715.wordsearch.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Immutable POJO representing a difficulty setting for a word-search.
 */
public class Difficulty {

    private DifficultyEnum value;
    private List<WordDirectionEnum> directions;

    public Difficulty(DifficultyEnum value) {
        this.value = value;
        this.directions = new ArrayList<>();
        switch (value) {
            case BRUTAL:
                this.directions.addAll(Arrays.asList(WordDirectionEnum.DIAGONAL_LEFT_DOWN, WordDirectionEnum.DIAGONAL_LEFT_UP));
            case HARD:
                this.directions.addAll(Arrays.asList(WordDirectionEnum.HORIZONTAL_LEFT, WordDirectionEnum.VERTICAL_UP));
            case NORMAL:
                this.directions.addAll(Arrays.asList(WordDirectionEnum.DIAGONAL_RIGHT_DOWN, WordDirectionEnum.DIAGONAL_RIGHT_UP));
            case EASY:
                this.directions.addAll(Arrays.asList(WordDirectionEnum.HORIZONTAL_RIGHT, WordDirectionEnum.VERTICAL_DOWN));
        }
    }

    public DifficultyEnum getValue() {
        return this.value;
    }

    public List<WordDirectionEnum> getDirections() {
        return this.directions;
    }

    @Override
    public String toString() {
        return "Difficulty{" +
            "value=" + this.value +
            ", directions=" + this.directions +
            '}';
    }
}
