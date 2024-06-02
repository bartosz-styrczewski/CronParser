package org.interview.croneparser.parser.config;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class DayOfMonthTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "5",
            "31",
            "1,7",
            "1,5,31"
    })
    public void testMatchingValues(String input) {
        assertTrue(DayOfMonth.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "0",
            "0,",
            "32",
            "12,,",
            "123"
    })
    public void testNonMatchingValues(String input) {
        assertFalse(DayOfMonth.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1-31",
            "2-12"
    })
    public void testMatchingRanges(String input) {
        assertTrue(DayOfMonth.RANGES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1-13",
            "7",
            "1--2",
            "1-2-3",
            "",
            "-",
            "7--"

    })
    public void testNonMatchingRanges(String input) {
        assertFalse(DayOfMonth.RANGES_REGEX.matcher(input).matches());
    }

}