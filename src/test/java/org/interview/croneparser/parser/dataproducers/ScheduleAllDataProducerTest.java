package org.interview.croneparser.parser.dataproducers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleAllDataProducerTest {

    @ParameterizedTest
    @MethodSource("getValidExpressions")
    public void testValidExpression(String input, int min, int max, int[] result) {
        ScheduleAllDataProducer scheduleRangeDataProducer = new ScheduleAllDataProducer(min, max);
        int[] data = scheduleRangeDataProducer.getScheduleData(input);

        assertArrayEquals(result, data);
    }

    private static Stream<Arguments> getValidExpressions() {
        return Stream.of(
                Arguments.of("*", 1,3, new int[]{1, 2, 3}),
                Arguments.of("*", 0,2, new int[]{0, 1, 2})
        );
    }

}