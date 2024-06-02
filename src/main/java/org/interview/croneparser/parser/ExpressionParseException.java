package org.interview.croneparser.parser;

public class ExpressionParseException extends RuntimeException {
    public ExpressionParseException(String expression) {
        super(String.format("Cannot parse expression: %s", expression));
    }
}
