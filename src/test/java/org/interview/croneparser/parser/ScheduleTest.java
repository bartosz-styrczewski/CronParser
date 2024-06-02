package org.interview.croneparser.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    //FIXME
    @Test
    public void testPrettyString() {
        String result = Schedule.builder()
                .minutes(new int[]{0, 5, 59})
                .hours(new int[]{0, 15, 23})
                .build()
                .getPrettyString();

        assertEquals(
                        """
                        minute        0 5 59
                        hour          0 15 23
                        """
                        .trim(),
                result.trim()
        );
    }
}