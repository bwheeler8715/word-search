package com.bwheeler8715.wordsearch;

import java.util.Arrays;
import java.util.List;

/**
 * An immutable POJO representing a word-search.
 */
public class WordSearch {

    private char[][] field;
    private List<String> wordList;

    public WordSearch(char[][] field, List<String> wordList) {
        this.field = field;
        this.wordList = wordList;
    }

    public char[][] getField() {
        return this.field;
    }

    public List<String> getWordList() {
        return this.wordList;
    }

    @Override
    public String toString() {
        return "WordSearch{" +
            "field=" + Arrays.toString(this.field) +
            ", wordList=" + this.wordList +
            '}';
    }
}
