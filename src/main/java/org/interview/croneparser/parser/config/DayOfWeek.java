package org.interview.croneparser.parser.config;

import org.interview.croneparser.parser.dataproducers.ScheduleAllDataProducer;
import org.interview.croneparser.parser.dataproducers.ScheduleDataProducer;
import org.interview.croneparser.parser.dataproducers.ScheduleRangeDataProducer;
import org.interview.croneparser.parser.dataproducers.ScheduleValueDataProducer;

import java.util.Map;
import java.util.regex.Pattern;

public interface DayOfWeek {

    /**
     * Regex matching exact values and values separated by delimiter.
     * <p>
     * e.g. `2`, `1,3,7`
     */
    Pattern VALUES_REGEX = Pattern.compile("[1-7](,[1-7])*");

    /**
     * Regex matching range of values
     * <p>
     * e.g. `1-7`, `2-4`
     * <p>
     * Note that regex allows ranges with reversed order `5-2`
     */
    Pattern RANGES_REGEX = Pattern.compile("[1-7]-[1-7]");

    /**
     * Regex matching for all possible values.
     */
    Pattern ALL_REGEX = Pattern.compile("\\*");

    /**
     * Config containing pairs of regex and corresponding data producers which based on provided expression
     * will provide data for result schedule.
     */
    Map<Pattern, ScheduleDataProducer> config = Map.of(
            VALUES_REGEX, new ScheduleValueDataProducer(),
            RANGES_REGEX, new ScheduleRangeDataProducer(),
            ALL_REGEX, new ScheduleAllDataProducer(1, 7)
    );
}
