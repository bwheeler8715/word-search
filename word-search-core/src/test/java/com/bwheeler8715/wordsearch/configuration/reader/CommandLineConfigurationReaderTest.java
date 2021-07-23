package com.bwheeler8715.wordsearch.configuration.reader;

import com.bwheeler8715.wordsearch.configuration.Configuration;
import com.bwheeler8715.wordsearch.configuration.DifficultyEnum;
import com.bwheeler8715.wordsearch.exception.ReadConfigurationException;
import com.bwheeler8715.wordsearch.exception.ValidateConfigurationException;
import org.junit.Test;

import static com.bwheeler8715.wordsearch.TestDataBuilder.COMMAND_LINE_ARGS_BANNED_WORDS;
import static com.bwheeler8715.wordsearch.TestDataBuilder.COMMAND_LINE_ARGS_FAIL_TO_READ;
import static com.bwheeler8715.wordsearch.TestDataBuilder.COMMAND_LINE_ARGS_INVALID;
import static com.bwheeler8715.wordsearch.TestDataBuilder.COMMAND_LINE_ARGS_VALID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class CommandLineConfigurationReaderTest {

    @Test
    public void validCommandLineArgs_shouldReturnConfiguration() {
        try {
            ConfigurationReader reader = new CommandLineConfigurationReader(COMMAND_LINE_ARGS_VALID);

            reader.readConfiguration();

            reader.validateConfiguration();

            Configuration configuration = reader.getConfiguration();

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

    @Test
    public void invalidCommandLineArgs_readConfiguration_shouldThrowReadConfigurationException() {
        try {
            ConfigurationReader reader = new CommandLineConfigurationReader(COMMAND_LINE_ARGS_FAIL_TO_READ);

            reader.readConfiguration();
        } catch (ReadConfigurationException e) {
            // pass
            assertEquals("ReadConfigurationException errors size mis-match", 3, e.getErrors().size());
            return;
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
        fail("should throw ReadConfigurationException");
    }

    @Test
    public void invalidCommandLineArgs_validateConfiguration_shouldThrowValidateConfigurationException() {
        try {
            ConfigurationReader reader = new CommandLineConfigurationReader(COMMAND_LINE_ARGS_INVALID);

            reader.readConfiguration();

            reader.validateConfiguration();
        } catch (ValidateConfigurationException e) {
            // pass
            assertEquals("ValidateConfigurationException errors size mis-match", 4, e.getErrors().size());
            return;
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
        fail("should throw ValidateConfigurationException");
    }

    @Test
    public void invalidCommandLineArgs_validateConfiguration_bannedWords_shouldThrowValidateConfigurationException() {
        try {
            ConfigurationReader reader = new CommandLineConfigurationReader(COMMAND_LINE_ARGS_BANNED_WORDS);

            reader.readConfiguration();

            reader.validateConfiguration();
        } catch (ValidateConfigurationException e) {
            // pass
            assertEquals("ValidateConfigurationException errors size mis-match", 1, e.getErrors().size());
            return;
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
        fail("should throw ValidateConfigurationException");
    }
}
