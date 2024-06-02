package org.interview.croneparser.parser;

import lombok.Builder;

import java.util.Arrays;

/**
 * Result of expression parsing. Able of printing result in human-readable form.
 */
@Builder
public class Schedule {

    private int[] minutes;
    private int[] hours;
    private int[] daysOfMonth;
    private int[] months;
    private int[] daysOfWeek;
    private String command;

    public void prettyPrint() {
        System.out.println(getPrettyString());
    }

    protected String getPrettyString() {

        return new StringBuilder()
                .append(String.format("%-14s", "minute"))
                .append(getValuesAsString(minutes))
                .append("\n")
                .append(String.format("%-14s", "hour"))
                .append(getValuesAsString(hours))
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
