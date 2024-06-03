package org.interview.croneparser.parser;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CroneParserTest {

    @ParameterizedTest
    @MethodSource("getValidExpressions")
    public void testCorrectExpressions(String expression, Schedule expectedSchedule) {
        CroneParser croneParser = new CroneParser();
        Schedule resultSchedule = croneParser.parseExpression(expression);

        assertEquals(expectedSchedule, resultSchedule);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1,2 2-4 1 1 1 /usr/bin/find",
            "1,2 2-25 1 1 1 /usr/bin/find",
            "1,2 2-4 0 1 1 /usr/bin/find",
            "1,2 2-4 1 13 1 /usr/bin/find",
            "1,2 2-4 1 1 8 /usr/bin/find"

    })
    public void testBadExpressions(String expression) {
        CroneParser croneParser = new CroneParser();

        assertThrows(ExpressionParseException.class, () -> croneParser.parseExpression(expression));
    }

    private static Stream<Arguments> getValidExpressions() {

        Schedule schedule = Schedule.builder()
                .minutes(new int[]{1, 2})
                .hours(new int[]{2, 3, 4})
                .daysOfMonth(new int[]{1})
                .months(new int[]{1})
                .daysOfWeek(new int[]{1, 2, 3, 4, 5, 6, 7})
                .command("/usr/bin/find")
                .build();

        return Stream.of(
                Arguments.of("1,2 2-4 1 1 * /usr/bin/find", schedule)
        );
    }
}