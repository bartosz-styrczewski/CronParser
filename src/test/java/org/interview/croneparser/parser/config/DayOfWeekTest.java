package org.interview.croneparser.parser.config;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DayOfWeekTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "4",
            "7",
            "1,7",
            "1,5,7"
    })
    public void testMatchingValues(String input) {
            assertTrue(DayOfWeek.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "8",
            "0,",
            "12,,"
    })
    public void testNonMatchingValues(String input) {
        assertFalse(DayOfWeek.VALUES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1-7",
            "2-5"
    })
    public void testMatchingRanges(String input) {
        assertTrue(DayOfWeek.RANGES_REGEX.matcher(input).matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1-7",
            "8",
            "1--2",
            "1-2-3",
            "",
            "-",
            "8--"

    })
    public void testNonMatchingRanges(String input) {
        assertFalse(DayOfWeek.RANGES_REGEX.matcher(input).matches());
    }
}