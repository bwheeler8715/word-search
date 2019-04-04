package com.bwheeler8715.wordsearch.configuration;

import com.bwheeler8715.wordsearch.configuration.reader.CommandLineConfigurationReader;
import com.bwheeler8715.wordsearch.configuration.reader.ConfigurationReader;
import com.bwheeler8715.wordsearch.configuration.reader.DefaultConfigurationReader;
import com.bwheeler8715.wordsearch.exception.ReadConfigurationException;
import com.bwheeler8715.wordsearch.exception.ValidateConfigurationException;

/**
 * A factory for determining what type of {@link ConfigurationReader} is
 * necessary, then reading, validating, and generating the {@link Configuration}.
 */
public final class ConfigurationFactory {

    /**
     * Get the {@link Configuration}.
     *
     * @param commandLineArgs The command line args passed to the app.
     * @return A {@link Configuration}.
     * @throws ReadConfigurationException     - If there is an error reading the input.
     * @throws ValidateConfigurationException - If there is an error validating the values.
     */
    public static Configuration getConfiguration(String[] commandLineArgs) throws ReadConfigurationException, ValidateConfigurationException {
        ConfigurationReader reader;

        // Determine what kind of ConfigurationReader to use.
        if (commandLineArgs == null || commandLineArgs.length == 0) {
            reader = new DefaultConfigurationReader();
        } else {
            reader = new CommandLineConfigurationReader(commandLineArgs);
        }
        // TODO: could add other ConfigurationReaders (file, xml, json, csv).

        // Read the configuration. Throws ReadConfigurationException on error.
        reader.readConfiguration();

        // Validate the configuration. Throws ValidateConfigurationException on error.
        reader.validateConfiguration();

        // Return the configuration from the ConfigurationReader.
        return reader.getConfiguration();
    }

    private ConfigurationFactory() {
    }
}
