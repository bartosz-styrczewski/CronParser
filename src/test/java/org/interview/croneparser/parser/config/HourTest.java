package org.interview.croneparser.parser.config;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HourTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "0",
            "12",
            "23",
            "0,23",
            "0,12,23"
    })
    public void testMatchingValues(String input) {
        assertTrue(Hour.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "24",
            "0,",
            "12,,"
    })
    public void testNonMatchingValues(String input) {
        assertFalse(Hour.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0-23",
            "1-22"
    })
    public void testMatchingRanges(String input) {
        assertTrue(Hour.RANGES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1-13",
            "23",
            "1--2",
            "1-2-3",
            "",
            "-",
            "23--"

    })
    public void testNonMatchingRanges(String input) {
        assertFalse(Hour.RANGES_REGEX.matcher(input).matches());
    }
}