package com.bwheeler8715.wordsearch.word;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WordValidatorSingletonTest {

    @Test
    public void getWordValidatorTwice_shouldBeTheSameObject() {
        WordValidator validator1 = WordValidatorSingleton.getWordValidator();
        assertNotNull("validator1 is null", validator1);

        WordValidator validator2 = WordValidatorSingleton.getWordValidator();
        assertNotNull("validator2 is null", validator2);

        assertEquals("validators not equal", validator1, validator2);
    }
}
