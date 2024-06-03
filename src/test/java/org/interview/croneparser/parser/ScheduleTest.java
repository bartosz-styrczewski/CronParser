package org.interview.croneparser.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @Test
    public void testPrettyString() {
        String result = Schedule.builder()
                .minutes(new int[]{0, 5, 59})
                .hours(new int[]{0, 15, 23})
                .daysOfMonth(new int[]{1, 15, 31})
                .months(new int[]{1, 6, 12})
                .daysOfWeek(new int[]{1, 3, 7})
                .command("testCommand")
                .build()
                .getPrettyString();

        assertEquals(
                        """
                        minute        0 5 59
                        hour          0 15 23
                        day of month  1 15 31
                        month         1 6 12
                        day of week   1 3 7
                        command       testCommand
                        """
                        .trim(),
                result.trim()
        );
    }
}