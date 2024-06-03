package org.interview.croneparser.parser.config;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonthTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "7",
            "12",
            "1,2",
            "1,12",
            "2,7,9"
    })
    public void testMatchingValues(String input) {
        assertTrue(Month.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "13",
            "0,",
            "12,,"
    })
    public void testNonMatchingValues(String input) {
        assertFalse(Month.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1-12",
            "2-6"
    })
    public void testMatchingRanges(String input) {
        assertTrue(Month.RANGES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1-13",
            "13",
            "1--2",
            "1-2-3",
            "",
            "-",
            "23--"

    })
    public void testNonMatchingRanges(String input) {
        assertFalse(Month.RANGES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "*"
    })
    public void testMatchingAll(String input) {
        assertTrue(Month.ALL_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "**",
            "*-*",
            "*,*"
    })
    public void testNonMatchingAll(String input) {
        assertFalse(Month.ALL_REGEX.matcher(input).matches());
    }
}