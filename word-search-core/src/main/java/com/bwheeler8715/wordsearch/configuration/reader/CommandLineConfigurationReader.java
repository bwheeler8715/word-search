package com.bwheeler8715.wordsearch.configuration.reader;

import com.bwheeler8715.wordsearch.configuration.DifficultyEnum;
import com.bwheeler8715.wordsearch.exception.ReadConfigurationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A command line configuration reader. As the name suggests, this reads its input
 * off the command line.
 * <p>
 * <pre>
 * command line arguments are as follows:
 *      [difficulty] [gridSizeX] [gridSizeY] [word...]
 * </pre>
 * <p>
 * difficulty: one of EASY, NORMAL, HARD, BRUTAL
 * gridSizeX: size of the grid in the X direction
 * gridSizeY: size of the grid in the Y direction
 * word...: list of word to search for
 */
public class CommandLineConfigurationReader extends AbstractConfigurationReader {

    public CommandLineConfigurationReader(String[] commandLineArgs) {
        Objects.requireNonNull(commandLineArgs, "commandLineArgs is required");
        this.commandLineArgs = commandLineArgs;
    }

    @Override
    public void readConfiguration() throws ReadConfigurationException {
        List<String> errors = new ArrayList<>();

        try {
            try {
                this.difficulty = Optional.ofNullable(this.commandLineArgs[0]).map(String::toUpperCase).map(DifficultyEnum::valueOf).orElse(null);
            } catch (IllegalArgumentException e) {
                errors.add("There was an error reading the difficulty.");
            }

            try {
                this.gridSizeX = Optional.ofNullable(this.commandLineArgs[1]).map(Integer::new).orElse(-1);
            } catch (NumberFormatException e) {
                errors.add("There was an error reading the grid X size.");
            }

            try {
                this.gridSizeY = Optional.ofNullable(this.commandLineArgs[2]).map(Integer::new).orElse(-1);
            } catch (NumberFormatException e) {
                errors.add("There was an error reading the grid Y size.");
            }

            this.words = Arrays.stream(this.commandLineArgs).skip(3).map(String::toUpperCase).collect(Collectors.toList());
        } catch (Exception e) {
            errors.add("There was an unknown error reading the configuration.");
        }

        if (!errors.isEmpty()) {
            throw new ReadConfigurationException(errors);
        }
    }
}
