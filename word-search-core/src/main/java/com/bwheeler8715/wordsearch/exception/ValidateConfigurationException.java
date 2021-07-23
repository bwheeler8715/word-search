package com.bwheeler8715.wordsearch.exception;

import java.util.List;

/**
 * {@link ConfigurationException} used when an error occurs while validating a configuration.
 */
public class ValidateConfigurationException extends ConfigurationException {

    public ValidateConfigurationException(List<String> errors) {
        super(errors);
    }
}
