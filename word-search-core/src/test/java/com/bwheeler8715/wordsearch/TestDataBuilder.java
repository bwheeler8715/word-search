package com.bwheeler8715.wordsearch;

public final class TestDataBuilder {

    public static final String[] COMMAND_LINE_ARGS_VALID = new String[]{"EASY", "20", "20", "WORD", "LANGUAGE", "SPEAKING"};
    public static final String[] COMMAND_LINE_ARGS_INVALID = new String[]{null, "-3", "-2"};
    public static final String[] COMMAND_LINE_ARGS_FAIL_TO_READ = new String[]{"soigjfso", "uer", "sdgk"};
    public static final String[] COMMAND_LINE_ARGS_BANNED_WORDS = new String[]{"HARD", "421", "521", "ASS"};

    public static final String VALID_WORD = "VALIDWORD";
    public static final String BANNED_WORD = "ASSHOLE";
    public static final String BANNED_LIKE_WORD = "DICKMUNCHER";

    public static final String LOWER_CASE_WORD = "refrigerator";
    public static final String UPPER_CASE_WORD = "REFRIGERATOR";

    public static final String LEET_SPEAK_WORD = "!13@45790";
    public static final String LEET_SPEAK_REMOVED_WORD = "IIEAASTGO";

    private TestDataBuilder() {
    }
}
