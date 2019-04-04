package com.bwheeler8715.wordsearch;

import com.bwheeler8715.wordsearch.configuration.Configuration;
import com.bwheeler8715.wordsearch.configuration.DifficultyEnum;

import java.util.Arrays;

public final class TestDataBuilder {

    public static Configuration buildTestConfiguration() {
        return new Configuration(
            DifficultyEnum.NORMAL,
            15,
            15,
            Arrays.asList("Word", "search", "GENERATOR", "tEsT")
        );
    }

    private TestDataBuilder() {
    }
}
