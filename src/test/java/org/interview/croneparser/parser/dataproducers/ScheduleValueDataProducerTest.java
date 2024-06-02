package org.interview.croneparser.parser.dataproducers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScheduleValueDataProducerTest {
    @ParameterizedTest
    @MethodSource("getValidExpressions")
    public void testValidExpression(String input, int[] result) {
        ScheduleValueDataProducer scheduleRangeDataProducer = new ScheduleValueDataProducer();
        int[] data = scheduleRangeDataProducer.getScheduleData(input);

        assertArrayEquals(result, data);
    }


    private static Stream<Arguments> getValidExpressions() {
        return Stream.of(
                Arguments.of("0", new int[]{0}),
                Arguments.of("1,5,99", new int[]{1, 5, 99})
        );
    }

}