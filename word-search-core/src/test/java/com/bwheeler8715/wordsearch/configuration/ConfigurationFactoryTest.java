package com.bwheeler8715.wordsearch.configuration;

import org.junit.Test;

import static com.bwheeler8715.wordsearch.TestDataBuilder.COMMAND_LINE_ARGS_VALID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ConfigurationFactoryTest {

    @Test
    public void getConfiguration_defaultReader_nullCommandLineArgs() {
        try {
            Configuration configuration = ConfigurationFactory.getConfiguration(null);

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

    @Test
    public void getConfiguration_defaultReader_emptyCommandLineArgs() {
        try {
            Configuration configuration = ConfigurationFactory.getConfiguration(new String[]{});

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

    @Test
    public void getConfiguration_commandLineReader_validCommandLineArgs() {
        try {
            Configuration configuration = ConfigurationFactory.getConfiguration(COMMAND_LINE_ARGS_VALID);

            assertNotNull("configuration is null", configuration);
            assertEquals("difficulty mis-match", DifficultyEnum.EASY, configuration.getDifficulty().getValue());
            assertEquals("grid size x mis-match", 20, configuration.getGridSizeX());
            assertEquals("grid size y mis-match", 20, configuration.getGridSizeY());
            assertEquals("word size mis-match", 3, configuration.getWords().size());
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
    }
}
