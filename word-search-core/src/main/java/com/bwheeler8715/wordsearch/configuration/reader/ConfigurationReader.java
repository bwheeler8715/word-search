package com.bwheeler8715.wordsearch.configuration.reader;

import com.bwheeler8715.wordsearch.configuration.Configuration;
import com.bwheeler8715.wordsearch.exception.ReadConfigurationException;
import com.bwheeler8715.wordsearch.exception.ValidateConfigurationException;

/**
 * Interface defining the necessary functions for a configuration reader.
 */
public interface ConfigurationReader {

    /**
     * Read a configuration from the input.
     *
     * @throws ReadConfigurationException - If there is an error reading the input.
     */
    void readConfiguration() throws ReadConfigurationException;

    /**
     * Validate all the necessary values were successfully read from hte input.
     *
     * @throws ValidateConfigurationException - If there is an error validating the values.
     */
    void validateConfiguration() throws ValidateConfigurationException;

    /**
     * Create and retrieve the configuration read from the input.
     *
     * @return A {@link Configuration}.
     */
    Configuration getConfiguration();
}
