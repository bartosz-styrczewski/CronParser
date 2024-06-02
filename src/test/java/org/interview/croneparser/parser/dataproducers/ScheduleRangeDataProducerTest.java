package org.interview.croneparser.parser.dataproducers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ScheduleRangeDataProducerTest {

    @ParameterizedTest
    @MethodSource("getValidExpressions")
    public void testValidExpression(String input, int[] result) {
        ScheduleRangeDataProducer scheduleRangeDataProducer = new ScheduleRangeDataProducer();
        int[] data = scheduleRangeDataProducer.getScheduleData(input);

        assertArrayEquals(result, data);
    }

    private static Stream<Arguments> getValidExpressions() {
        return Stream.of(
                Arguments.of("0-3", new int[]{0, 1, 2, 3}),
                Arguments.of("9-12", new int[]{9, 10, 11, 12})
        );
    }
}