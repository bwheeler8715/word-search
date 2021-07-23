package com.bwheeler8715.wordsearch.word;

import java.util.Locale;
import java.util.Objects;

/**
 * A singleton defining a {@link WordValidator} that is used throughout the life
 * of the application.
 * <p>
 * It can be explicitly initialized in any supported languages. If it is not then
 * when first accessed it defaults to english.
 */
public final class WordValidatorSingleton {

    private static volatile WordValidator INSTANCE;

    public synchronized static void initializeWordValidator(Locale locale) throws IllegalArgumentException {
        if (INSTANCE == null) {
            Objects.requireNonNull(locale, "locale is required.");

            if (Locale.ENGLISH.equals(locale)) {
                // TODO: other implementations could use an established banned word dictionary
                INSTANCE = new CustomEnglishWordValidator();
            } else {
                // TODO: could add more language support
                throw new IllegalArgumentException(String.format("The Locale %s is not supported.", locale.toString()));
            }
        }
    }

    public static WordValidator getWordValidator() {
        if (INSTANCE == null) {
            synchronized (WordValidatorSingleton.class) {
                // If the word validator has not been initialized explicitly previously use Locale.ENGLISH
                initializeWordValidator(Locale.ENGLISH);
            }
        }
        return INSTANCE;
    }

    private WordValidatorSingleton() {
    }
}
