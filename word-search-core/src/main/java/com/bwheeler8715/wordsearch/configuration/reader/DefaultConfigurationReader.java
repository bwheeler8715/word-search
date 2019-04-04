package com.bwheeler8715.wordsearch.configuration.reader;

import com.bwheeler8715.wordsearch.configuration.DifficultyEnum;
import com.bwheeler8715.wordsearch.exception.ReadConfigurationException;

import java.util.Arrays;
import java.util.Collections;

/**
 * A default configuration reader. Sets difficulty to 'NORMAL' with a grid of 15 x 15
 * and a default word list containing computer terms.
 * <p>
 * This is used if no arguments are passed when running the program.
 */
public class DefaultConfigurationReader extends AbstractConfigurationReader {

    @Override
    public void readConfiguration() throws ReadConfigurationException {
        try {
            this.difficulty = DifficultyEnum.NORMAL;
            this.gridSizeX = 15;
            this.gridSizeY = 15;
            this.words = Arrays.asList("MONITOR", "KEYBOARD", "MOUSE", "SPEAKER", "PRINTER",
                "SOFTWARE", "HARDWARE", "USB", "HARDDRIVE", "INTERNET");
        } catch (Exception e) {
            throw new ReadConfigurationException(Collections.singletonList("There was an unknown error reading the configuration"));
        }
    }
}
