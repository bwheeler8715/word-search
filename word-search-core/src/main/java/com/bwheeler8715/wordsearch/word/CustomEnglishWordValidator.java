package com.bwheeler8715.wordsearch.word;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Simple custom implementation of an English banned/curse/bad word validator.
 * Provides its own list and checking method of banned word.
 */
public class CustomEnglishWordValidator extends AbstractEnglishWordValidator {

    private static final Set<String> BANNEDWORDS = new HashSet<>(Arrays.asList(
        "ASS",
        "ASSHOLE",
        "BASTARD",
        "BITCH",
        "BLOWJOB",
        "BONER",
        "CUNT",
        "DAMN",
        "DAMNIT",
        "DILDO",
        "DIKE",
        "DOUCH",
        "DOUCHBAG",
        "FAG",
        "FAGGOT",
        "FAGGIT",
        "HANDJOB",
        "HARDON",
        "HO",
        "HOMO",
        "JACKOFF",
        "JERKOFF",
        "KUNT",
        "MUFF",
        "NIGABOO",
        "NIGGA",
        "NIGLET",
        "NUTSACK",
        "PUSSIES",
        "PUSSY",
        "RIMJOB",
        "SLUT",
        "VAGINA"
    ));

    private static final Set<String> BANNEDLIKEWORDS = new HashSet<>(Arrays.asList(
        "COCK",
        "CUM",
        "DICK",
        "DYKE",
        "FUCK",
        "JIZZ",
        "NIGGER",
        "PENIS",
        "SHIT",
        "TWAT",
        "WHORE"
    ));

    @Override
    public boolean validateWord(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        word = removeLeetSpeak(word);
        return !BANNEDWORDS.contains(word) && BANNEDLIKEWORDS.stream().noneMatch(word::contains);
    }
}
