package com.bwheeler8715.wordsearch.word;

/**
 * Interface defining a validator to check the word list passed in the configuration
 * and filter out an banned/curse/bad words. Also provides an alphabet and a way to
 * retrieve a random character to be used when filling in the non word spots
 * in the word-search.
 */
public interface WordValidator {

    /**
     * Validate a word against the banned criteria.
     *
     * @param word - The word to check.
     * @return Whether the word is allowed or not.
     */
    boolean validateWord(String word);

    /**
     * Remove any 'leet speak' characters from a word and convert them to a normal
     * letter.
     *
     * @param word - The word to check.
     * @return The 'leet speak' removed word.
     */
    String removeLeetSpeak(String word);

    /**
     * Get a random char from the alphabet.
     *
     * @return The random char.
     */
    char getRandomCharacter();
}
