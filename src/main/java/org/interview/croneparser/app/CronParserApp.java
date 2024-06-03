package org.interview.croneparser.app;

import lombok.extern.java.Log;
import org.interview.croneparser.parser.CroneParser;
import org.interview.croneparser.parser.Schedule;

@Log
public class CronParserApp {
    public static void main(String[] args) {

        log.info("Crone Parser App running ...");

        CroneParser croneParser = new CroneParser();
        Schedule schedule = croneParser.parseExpression(args[0]);
        schedule.prettyPrint();

        log.info("Crone Parser App shutting down ...");
    }
}
