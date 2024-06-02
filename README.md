# CronParser
 Simple command line tool for parsing crone expressions
## Prerequisites
* java21
* mvn 3.9.x
## Test
`mvn clean test`
## Build 
`mvn clean package`
## Run
`java -jar CronParser-0.1-SNAPSHOT.jar */15 0 1,15 * 1-5 /usr/bin/find`