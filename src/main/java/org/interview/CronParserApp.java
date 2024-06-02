package org.interview;

import lombok.extern.java.Log;

@Log
public class CronParserApp {
    public static void main(String[] args) {

        log.info("Crone Parser App running ...");

        CroneParser croneParser = new CroneParser();
        ParsingResult parsingResult = croneParser.parseExpression(args[0]);
        parsingResult.prettyPrint();

        log.info("Crone Parser App running shutting down ...");
    }
}
