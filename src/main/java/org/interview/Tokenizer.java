package org.interview;

/**
 * TODO document me
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
