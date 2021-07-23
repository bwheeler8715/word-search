package com.bwheeler8715.wordsearch.exception;

import java.util.List;

/**
 * {@link ConfigurationException} used when an error occurs while reading a configuration.
 */
public class ReadConfigurationException extends ConfigurationException {

    public ReadConfigurationException(List<String> errors) {
        super(errors);
    }
}
