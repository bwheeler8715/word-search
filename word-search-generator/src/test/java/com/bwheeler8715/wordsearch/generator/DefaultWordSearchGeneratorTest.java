package com.bwheeler8715.wordsearch.generator;

import com.bwheeler8715.wordsearch.WordSearch;
import org.junit.Test;

import static com.bwheeler8715.wordsearch.TestDataBuilder.buildTestConfiguration;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class DefaultWordSearchGeneratorTest {

    @Test
    public void generateWordSearch() {
        try {
            WordSearchGenerator generator = new DefaultWordSearchGenerator(buildTestConfiguration());
            WordSearch wordSearch = generator.generateWordSearch();
            assertNotNull("wordSearch is null", wordSearch);
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
    }
}
