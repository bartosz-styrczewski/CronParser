package org.interview.croneparser.parser.dataproducers;

import java.util.Arrays;

public class ScheduleValueDataProducer implements ScheduleDataProducer {
    private static final String COMMA = ",";

    @Override
    public int[] getScheduleData(String expression) {

        String[] values = expression.split(COMMA);
        return Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
