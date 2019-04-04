package com.bwheeler8715.wordsearch.exception;

import java.util.List;

/**
 * Exception used for configuration errors. Contains a list of the errors.
 */
public class ConfigurationException extends Exception {

    private List<String> errors;

    public List<String> getErrors() {
        return this.errors;
    }

    public ConfigurationException(List<String> errors) {
        super();
        this.errors = errors;
    }
}
