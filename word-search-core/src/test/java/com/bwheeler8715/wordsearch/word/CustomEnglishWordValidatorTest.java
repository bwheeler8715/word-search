package com.bwheeler8715.wordsearch.word;

import org.junit.Test;

import static com.bwheeler8715.wordsearch.TestDataBuilder.BANNED_LIKE_WORD;
import static com.bwheeler8715.wordsearch.TestDataBuilder.BANNED_WORD;
import static com.bwheeler8715.wordsearch.TestDataBuilder.LEET_SPEAK_REMOVED_WORD;
import static com.bwheeler8715.wordsearch.TestDataBuilder.LEET_SPEAK_WORD;
import static com.bwheeler8715.wordsearch.TestDataBuilder.LOWER_CASE_WORD;
import static com.bwheeler8715.wordsearch.TestDataBuilder.UPPER_CASE_WORD;
import static com.bwheeler8715.wordsearch.TestDataBuilder.VALID_WORD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CustomEnglishWordValidatorTest {

    @Test
    public void validateWord_validWord_shouldReturnTrue() {
        try {
            WordValidator wordValidator = new CustomEnglishWordValidator();

            boolean valid = wordValidator.validateWord(VALID_WORD);
            assertTrue("valid word is not true", valid);
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
    }

    @Test
    public void validateWord_emptyWord_shouldReturnFalse() {
        try {
            WordValidator wordValidator = new CustomEnglishWordValidator();

            boolean valid = wordValidator.validateWord("");
            assertFalse("empty word is not false", valid);
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
    }

    @Test
    public void validateWord_nullWord_shouldReturnFalse() {
        try {
            WordValidator wordValidator = new CustomEnglishWordValidator();

            boolean valid = wordValidator.validateWord(null);
            assertFalse("null word is not false", valid);
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
    }

    @Test
    public void validateWord_bannedWord_shouldReturnFalse() {
        try {
            WordValidator wordValidator = new CustomEnglishWordValidator();

            boolean valid = wordValidator.validateWord(BANNED_WORD);
            assertFalse("banned word is not false", valid);
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
    }

    @Test
    public void validateWord_bannedLikeWord_shouldReturnFalse() {
        try {
            WordValidator wordValidator = new CustomEnglishWordValidator();

            boolean valid = wordValidator.validateWord(BANNED_LIKE_WORD);
            assertFalse("banned like word is not false", valid);
        } catch (Exception e) {
            e.printStackTrace();
            fail("should not throw Exception");
        }
    }

    @Test
    public void removeLeetSpeak_testUppercasing() {
        WordValidator wordValidator = new CustomEnglishWordValidator();

        String word = wordValidator.removeLeetSpeak(LOWER_CASE_WORD);
        assertEquals("uppercase word mis-match", UPPER_CASE_WORD, word);
    }

    @Test
    public void removeLeetSpeak_testCharReplacment() {
        WordValidator wordValidator = new CustomEnglishWordValidator();

        String word = wordValidator.removeLeetSpeak(LEET_SPEAK_WORD);
        assertEquals("leetspeak word mis-match", LEET_SPEAK_REMOVED_WORD, word);
    }

    @Test
    public void getRandomCharacter() {
        WordValidator wordValidator = new CustomEnglishWordValidator();

        char c = wordValidator.getRandomCharacter();
        assertTrue("c not in alphabet", AbstractEnglishWordValidator.ALPHABET.contains(Character.toString(c)));
    }
}
