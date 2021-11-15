Requirements
------------
* Java >= 1.8 (OpenJDK and Oracle JVMS have been tested)
* mvn >= 3+

Compile and installation
-----------------
- `mvn clean install`

Above command cleans, format the code using google formatter plugin, compiles, runs test cases and generates report under site/jacoco.
Generates three Jars `file-parser-1.0-SNAPSHOT.jar`, `file-parser-1.0-SNAPSHOT-javadoc.jar`, `file-parser-1.0-SNAPSHOT-jar-with-dependencies.jar` and  also generates html documents under target/apidocs


Run Main program using jar
---------------------------
Please run below command after replacing placeholders`<>` appropriately

`java -jar "<abslloute path to jar with dependcies>/file-parser-1.0-SNAPSHOT-jar-with-dependencies.jar" "<abslloute path to jar with dependcies>/<filname>.<etension>"`

Sample jar command:

`java -jar "/Users/jetta/IdeaProjects/file-parser/target/file-parser-1.0-SNAPSHOT-jar-with-dependencies.jar" "/Users/jetta/IdeaProjects/file-parser/src/main/resources/test.tab"`

Result for above sample command below:
```
00:12:11.714 [main] DEBUG com.company.fileparser.entry.Main - program started it will print line tokens to console using log4j
00:12:12.004 [main] DEBUG com.company.fileparser.entry.Main - [This, is, a, test]
00:12:12.005 [main] DEBUG com.company.fileparser.entry.Main - [red, green, blue]
00:12:12.005 [main] DEBUG com.company.fileparser.entry.Main - program completed

```
Assumptions/enhancements required
---------------
* Given file to be parsed in `UTF_8` format.
* Exceptions that were re-thrown/thrown need to be custom Exception class in real project but in this project used Exception class.
* `validExtensions.properties` is hardcoded in class but in real project we load all property file under resource folder instead of hardcoding.

Simple customized configurations
-----------------------------------
* User can edit log4j file under resource folder according to need.
* `validExtensions.properties` key as new extension and value as java regex pattern to split line into tokens


