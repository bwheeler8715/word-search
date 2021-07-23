package com.bwheeler8715.wordsearch.generator;

import com.bwheeler8715.wordsearch.WordSearch;
import com.bwheeler8715.wordsearch.configuration.Configuration;
import com.bwheeler8715.wordsearch.configuration.ConfigurationFactory;
import com.bwheeler8715.wordsearch.exception.ConfigurationException;
import com.bwheeler8715.wordsearch.exception.WordSearchGenerationFailureException;
import com.bwheeler8715.wordsearch.word.WordValidatorSingleton;

import java.util.Arrays;
import java.util.Locale;

public class WordSearchGeneratorApplication {

    public static void main(String... args) {
        // Check for usage options
        if (args != null && args.length > 0 && args[0] != null && Arrays.asList("-U", "-USAGE").contains(args[0].toUpperCase())) {
            printUsage();
            return;
        }

        // Initialize the word validator
        WordValidatorSingleton.initializeWordValidator(Locale.ENGLISH);

        // Initialize the configuration
        Configuration config;
        try {
            config = ConfigurationFactory.getConfiguration(args);
        } catch (ConfigurationException e) {
            e.getErrors().forEach(System.out::println);
            return;
        } catch (Exception e) {
            System.out.println("There was an unexpected error reading the configuration.");
            e.printStackTrace();
            return;
        }

        // Generate the word search.
        WordSearch wordSearch;
        try {
            WordSearchGenerator generator = new DefaultWordSearchGenerator(config);
            wordSearch = generator.generateWordSearch();
        } catch (WordSearchGenerationFailureException e) {
            System.out.println("Could not generate a word search using the current configuration.");
            return;
        } catch (Exception e) {
            System.out.println("There was an unexpected error generating the word search.");
            e.printStackTrace();
            return;
        }

        // Print to console.
        printWordSearch(wordSearch);
    }

    private static void printUsage() {
        System.out.println("usage of 'Word Search': [options] [difficulty] [gridSizeX] [gridSizeY] [word...]");
        System.out.println("\toptions:");
        System.out.println("\t\t-U, -USAGE\tshows this usage message");
        System.out.println();
        System.out.println("\targuments:");
        System.out.println("\t\tdifficulty\tone of EASY, NORMAL, HARD, BRUTAL");
        System.out.println("\t\tgridSizeX\tsize of the grid in the X direction");
        System.out.println("\t\tgridSizeY\tsize of the grid in the Y direction");
        System.out.println("\t\tword...\tlist of word to search for");
        System.out.println();
        System.out.println("if no arguments are provided the defaults are used");
        System.out.println("\tdefaults:");
        System.out.println("\t\tdifficulty\tNORMAL");
        System.out.println("\t\tgridSizeX\t15");
        System.out.println("\t\tgridSizeY\t15");
        System.out.println("\t\tword...\tdefault list of computer terms");
    }

    private static void printWordSearch(WordSearch wordSearch) {
        for (int y = 0; y < wordSearch.getField().length; y++) {
            String line = "";
            for (int x = 0; x < wordSearch.getField()[0].length; x++) {
                line = line.concat(wordSearch.getField()[y][x] + " ");
            }
            System.out.println(line);
        }

        System.out.println();
        for (String word : wordSearch.getWordList()) {
            System.out.println(word);
        }
    }
}
