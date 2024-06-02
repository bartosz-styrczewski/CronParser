package org.interview.croneparser.parser;

import org.interview.croneparser.parser.config.Hour;
import org.interview.croneparser.parser.config.Minute;
import org.interview.croneparser.parser.dataproducers.ScheduleDataProducer;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * TODO document me
 */
public class CroneParser {

    private static final int MINUTE_INDX = 0;
    private static final int HOUR_INDX = 1;

    public Schedule parseExpression(String expression) {

        Tokenizer tokenizer = new Tokenizer();
        String[] tokens = tokenizer.tokenize(expression);
        return parseTokens(tokens);

    }

    //TODO document me
    private Schedule parseTokens(String[] tokens) {

        int[] minutes = getDataFromProducer(tokens[MINUTE_INDX], Minute.config);
        int[] hours = getDataFromProducer(tokens[HOUR_INDX], Hour.config);

        return Schedule.builder()
                .minutes(minutes)
                .hours(hours)
                .build();
    }

    private static int[] getDataFromProducer(String expression, Map<Pattern, ScheduleDataProducer> config) {
        return config.entrySet().stream()
                .filter(e -> e.getKey().matcher(expression).matches())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new ExpressionParseException(expression))
                .getScheduleData(expression);
    }
}
