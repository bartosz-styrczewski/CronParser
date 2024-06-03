package org.interview.croneparser.parser.dataproducers;

import java.util.stream.IntStream;

public class ScheduleAllDataProducer implements ScheduleDataProducer{

    private final int min;
    private final int max;

    public ScheduleAllDataProducer(int min, int max) {

        this.min = min;
        this.max = max;
    }

    @Override
    public int[] getScheduleData(String expression) {

        return IntStream.range(min, max + 1).toArray();
    }
}
