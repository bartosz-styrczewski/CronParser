package org.interview.croneparser.parser;

import lombok.extern.java.Log;
import org.interview.croneparser.parser.config.*;
import org.interview.croneparser.parser.dataproducers.ScheduleDataProducer;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Simple crone expression parser. Able of tokenize given input, interpret token,
 * produce scheduler data base on token interpretation and print the result.
 */
@Log
public class CroneParser {

    private static final int MINUTE_INDX = 0;
    private static final int HOUR_INDX = 1;
    private static final int DAY_OF_MONTH_INDX = 2;
    private static final int MONTH_INDX = 3;
    private static final int DAY_OF_WEEK_INDX = 4;
    private static final int COMMAND_INDX = 5;

    public Schedule parseExpression(String expression) {

        log.info(()->"Parsing expression: " + expression);

        Tokenizer tokenizer = new Tokenizer();
        String[] tokens = tokenizer.tokenize(expression);
        return parseTokens(tokens);

    }

    private Schedule parseTokens(String[] tokens) {

        int[] minutes = getDataFromProducer(tokens[MINUTE_INDX], Minute.config);
        int[] hours = getDataFromProducer(tokens[HOUR_INDX], Hour.config);
        int[] daysOfMonth = getDataFromProducer(tokens[DAY_OF_MONTH_INDX], DayOfMonth.config);
        int[] months = getDataFromProducer(tokens[MONTH_INDX], Month.config);
        int[] daysOfWeek = getDataFromProducer(tokens[DAY_OF_WEEK_INDX], DayOfWeek.config);

        return Schedule.builder()
                .minutes(minutes)
                .hours(hours)
                .daysOfMonth(daysOfMonth)
                .months(months)
                .daysOfWeek(daysOfWeek)
                .command(tokens[COMMAND_INDX])
                .build();
    }

    /**
     * The method for a given expression filters the provided configuration based on regex patterns
     * and uses the found implementation of ScheduleDataProducer to supply data to the scheduler.
     */
    private static int[] getDataFromProducer(String expression, Map<Pattern, ScheduleDataProducer> config) {
        return config.entrySet().stream()
                .filter(e -> e.getKey().matcher(expression).matches())
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new ExpressionParseException(expression))
                .getScheduleData(expression);
    }
}
