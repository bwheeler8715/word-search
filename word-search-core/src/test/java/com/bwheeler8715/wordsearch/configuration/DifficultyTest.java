package com.bwheeler8715.wordsearch.configuration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DifficultyTest {

    @Test
    public void checkDifficulty_easy() {
        Difficulty difficulty = new Difficulty(DifficultyEnum.EASY);
        assertNotNull("difficulty is null", difficulty);
        assertEquals("value mis-match", DifficultyEnum.EASY, difficulty.getValue());
        assertEquals("directions size mis-match", 2, difficulty.getDirections().size());
    }

    @Test
    public void checkDifficulty_normal() {
        Difficulty difficulty = new Difficulty(DifficultyEnum.NORMAL);
        assertNotNull("difficulty is null", difficulty);
        assertEquals("value mis-match", DifficultyEnum.NORMAL, difficulty.getValue());
        assertEquals("directions size mis-match", 4, difficulty.getDirections().size());
    }

    @Test
    public void checkDifficulty_hard() {
        Difficulty difficulty = new Difficulty(DifficultyEnum.HARD);
        assertNotNull("difficulty is null", difficulty);
        assertEquals("value mis-match", DifficultyEnum.HARD, difficulty.getValue());
        assertEquals("directions size mis-match", 6, difficulty.getDirections().size());
    }

    @Test
    public void checkDifficulty_brutal() {
        Difficulty difficulty = new Difficulty(DifficultyEnum.BRUTAL);
        assertNotNull("difficulty is null", difficulty);
        assertEquals("value mis-match", DifficultyEnum.BRUTAL, difficulty.getValue());
        assertEquals("directions size mis-match", 8, difficulty.getDirections().size());
    }
}
