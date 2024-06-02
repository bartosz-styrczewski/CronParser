package org.interview.croneparser.parser.dataproducers;

import java.util.stream.IntStream;

public class ScheduleRangeDataProducer implements ScheduleDataProducer{
        private static final String DASH = "-";
    @Override
    public int[] getScheduleData(String expression) {

        String[] range = expression.split(DASH);
        return IntStream.range(Integer.parseInt(range[0]), Integer.parseInt(range[1]) + 1)
                .toArray();
    }
}
