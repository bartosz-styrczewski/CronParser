package org.interview.croneparser.parser;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;

import java.util.Arrays;

/**
 * Result of expression parsing. Able of printing result in human-readable form.
 */
@Builder
@EqualsAndHashCode
@Log
public class Schedule {

    private int[] minutes;
    private int[] hours;
    private int[] daysOfMonth;
    private int[] months;
    private int[] daysOfWeek;
    private String command;

    public void prettyPrint() {
        log.info(getPrettyString());
    }

    protected String getPrettyString() {

        return new StringBuilder()
                .append("\n")
                .append(String.format("%-14s", "minute"))
                .append(getValuesAsString(minutes))
                .append("\n")
                .append(String.format("%-14s", "hour"))
                .append(getValuesAsString(hours))
                .append("\n")
                .append(String.format("%-14s", "day of month"))
                .append(getValuesAsString(daysOfMonth))
                .append("\n")
                .append(String.format("%-14s", "month"))
                .append(getValuesAsString(months))
                .append("\n")
                .append(String.format("%-14s", "day of week"))
                .append(getValuesAsString(daysOfWeek))
                .append("\n")
                .append(String.format("%-14s", "command"))
                .append(command)
                .toString();
    }

    private String getValuesAsString(int[] values) {
        return String.join(
                " ",
                Arrays.stream(values)
                        .mapToObj(String::valueOf)
                        .toList());
    }
}
