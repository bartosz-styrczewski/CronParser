package org.interview.croneparser.parser.config;

import org.interview.croneparser.parser.dataproducers.ScheduleDataProducer;
import org.interview.croneparser.parser.dataproducers.ScheduleRangeDataProducer;
import org.interview.croneparser.parser.dataproducers.ScheduleValueDataProducer;

import java.util.Map;
import java.util.regex.Pattern;

public interface Minute {

    /**
     * Regex matching exact values separated by delimiter.
     * <p>
     * e.g. `12`, `0,34,59`
     */
    Pattern VALUES_REGEX = Pattern.compile("[0-5][0-9]?(,[0-5][0-9]?)*");

    /**
     * Regex matching range of values
     * <p>
     * e.g. `0-59`, `12-34`
     * <p>
     * Note that regex allows ranges with reversed order `50-10`
     */
    Pattern RANGES_REGEX = Pattern.compile("[0-5][0-9]?-[0-5][0-9]?");

    /**
     * Config containing pairs of regex and corresponding data producers which based on provided expression
     * will provide data for result schedule.
     */
    Map<Pattern, ScheduleDataProducer> config = Map.of(
            VALUES_REGEX, new ScheduleValueDataProducer(),
            RANGES_REGEX, new ScheduleRangeDataProducer());
}
