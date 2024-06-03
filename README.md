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

`java -jar target\CronParser-0.1-SNAPSHOT.jar "0,2 0-5 1,2 1 * /usr/bin/find"`

> **_NOTE:_** for unix system change path separator

## Review notes
I have run out of time and didn't implement all possible expressions, 
especially the incremental expression `*/15`  
