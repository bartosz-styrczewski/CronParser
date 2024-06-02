package org.interview.croneparser;

import org.interview.croneparser.parser.Tokenizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenizerTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "*/15 0 1,15 * 1-5 /usr/bin/find",
            "   */15 0 1,15 * 1-5 /usr/bin/find \t",
            "*/15 0 1,15 * 1-5 /usr/bin/find \n"})
    public void testTokenizer(String expression) {
        Tokenizer tokenizer = new Tokenizer();
        String[] result = tokenizer.tokenize(expression);

        assertEquals(6, result.length);
        assertEquals("*/15", result[0]);
        assertEquals("0", result[1]);
        assertEquals("1,15", result[2]);
        assertEquals("*", result[3]);
        assertEquals("1-5", result[4]);
        assertEquals("/usr/bin/find", result[5]);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testEmptyAndNull(String expression) {
        Tokenizer tokenizer = new Tokenizer();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> tokenizer.tokenize(expression));
    }

}
