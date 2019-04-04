package com.bwheeler8715.wordsearch.word;

import java.util.Random;

/**
 * An abstract {@link WordValidator} for English that defines
 * shared functionality across all English WordValidators.
 * <p>
 * {@link WordValidator#removeLeetSpeak(String)} and
 * {@link WordValidator#getRandomCharacter()} will follow the same
 * rules in English regardless of how the validation is done.
 */
public abstract class AbstractEnglishWordValidator implements WordValidator {

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String removeLeetSpeak(String word) {
        return word.toUpperCase()
            .replaceAll("!", "I")
            .replaceAll("1", "I")
            .replaceAll("3", "E")
            .replaceAll("@", "A")
            .replaceAll("4", "A")
            .replaceAll("5", "S")
            .replaceAll("7", "T")
            .replaceAll("9", "G")
            .replaceAll("0", "O");
    }

    @Override
    public char getRandomCharacter() {
        Random random = new Random();
        int randomIndex = random.nextInt(ALPHABET.length());
        return ALPHABET.charAt(randomIndex);
    }
}
