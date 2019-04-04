package com.bwheeler8715.wordsearch.configuration.reader;

import com.bwheeler8715.wordsearch.configuration.Configuration;
import com.bwheeler8715.wordsearch.configuration.DifficultyEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class DefaultConfigurationReaderTest {

    @Test
    public void defaultConfigurationReader_shouldReturnConfiguration() {
        try {
            ConfigurationReader reader = new DefaultConfigurationReader();

            reader.readConfiguration();

            reader.validateConfiguration();

            Configuration configuration = reader.getConfiguration();

            assertNotNull("configuration is null", configuration);
            assertEquals("difficulty mis-match", DifficultyEnum.NORMAL, configuration.getDifficulty().getValue());
            assertEquals("grid size x mis-match", 15, configuration.getGridSizeX());
            assertEquals("grid size y mis-match", 15, configuration.getGridSizeY());
            assertEquals("word size mis-match", 10, configuration.getWords().size());
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
    }
}
