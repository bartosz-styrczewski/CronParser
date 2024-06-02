package org.interview.croneparser.parser;

/**
 * Tokenizer allows to break strings into tokens with space character as a space-delimiter.
 * Checks if input is null or empty and trims given string.
 */
public class Tokenizer {
    private static final String WHITESPACE_REGEX = "\\s+";

    public String[] tokenize(String expression) {

        checkNullOrEmpty(expression);
        return expression
                .trim()
                .split(WHITESPACE_REGEX);
    }

    private void checkNullOrEmpty(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Null or empty input expression");
        }
    }
}
