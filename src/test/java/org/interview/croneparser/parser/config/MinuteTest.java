package org.interview.croneparser.parser.config;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinuteTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "0",
            "12",
            "59",
            "1,2",
            "0,59",
            "0,59,12"
    })
    public void testMatchingValues(String input) {
        assertTrue(Minute.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "60",
            "0,",
            "12,,"
    })
    public void testNonMatchingValues(String input) {
        assertFalse(Minute.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0-59",
            "1-23"
    })
    public void testMatchingRanges(String input) {
        assertTrue(Minute.RANGES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1-13",
            "59",
            "1--2",
            "1-2-3",
            "",
            "-"
    })
    public void testNonMatchingRanges(String input) {
        assertFalse(Minute.RANGES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "*"
    })
    public void testMatchingAll(String input) {
        assertTrue(Minute.ALL_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "**",
            "*-*",
            "*,*"
    })
    public void testNonMatchingAll(String input) {
        assertFalse(Minute.ALL_REGEX.matcher(input).matches());
    }
}