package com.bwheeler8715.wordsearch.generator;

import com.bwheeler8715.wordsearch.WordSearch;
import com.bwheeler8715.wordsearch.exception.WordSearchGenerationFailureException;

/**
 * Interface defining the necessary functions for a word-search generator.
 */
public interface WordSearchGenerator {

    /**
     * Generate a word-search.
     *
     * @return The word-search.
     * @throws WordSearchGenerationFailureException - If the word search generator fails to find a valid layout
     */
    WordSearch generateWordSearch() throws WordSearchGenerationFailureException;
}
