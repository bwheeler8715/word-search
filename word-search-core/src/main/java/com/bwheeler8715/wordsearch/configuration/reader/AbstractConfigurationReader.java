package com.bwheeler8715.wordsearch.configuration.reader;

import com.bwheeler8715.wordsearch.configuration.Configuration;
import com.bwheeler8715.wordsearch.configuration.DifficultyEnum;
import com.bwheeler8715.wordsearch.exception.ValidateConfigurationException;
import com.bwheeler8715.wordsearch.word.WordValidator;
import com.bwheeler8715.wordsearch.word.WordValidatorSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract {@link ConfigurationReader} that defines shared functionality across
 * all ConfigurationReaders.
 * <p>
 * {@link ConfigurationReader#validateConfiguration()} and {@link ConfigurationReader#getConfiguration()}
 * will follow the same rules regardless of how the configuration was read.
 */
public abstract class AbstractConfigurationReader implements ConfigurationReader {

    protected String[] commandLineArgs;

    protected DifficultyEnum difficulty;
    protected int gridSizeX;
    protected int gridSizeY;
    protected List<String> words;

    @Override
    public void validateConfiguration() throws ValidateConfigurationException {
        List<String> errors = new ArrayList<>();

        if (this.difficulty == null) {
            errors.add("Difficulty cannot be null.");
        }

        if (this.gridSizeX < 10 || this.gridSizeX > 1000) {
            errors.add("Invalid grid size X; must be between 10 and 1000 inclusive.");
        }

        if (this.gridSizeY < 10 || this.gridSizeY > 1000) {
            errors.add("Invalid grid size Y; must be between 10 and 1000 inclusive.");
        }

        if (this.words.isEmpty()) {
            errors.add("There must be at least 1 word to search for.");
        }

        WordValidator validator = WordValidatorSingleton.getWordValidator();
        if (!this.words.stream().allMatch(validator::validateWord)) {
            errors.add("The word list contains banned word.");
        }

        if (!errors.isEmpty()) {
            throw new ValidateConfigurationException(errors);
        }
    }

    @Override
    public Configuration getConfiguration() {
        return new Configuration(
            this.difficulty,
            this.gridSizeX,
            this.gridSizeY,
            this.words
        );
    }
}
