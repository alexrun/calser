# Calculator Service

This Calculator Service is a PoC for exposing an API capable, based on input parameters, of performing arithmetic operations using Java language.

## Quickstart

To add the tracer jar dependency to your local maven repository use:
mvn install:install-file -Dfile=tracer-1.0.0.jar -DpomFile=pom.xml

To test this project use:
mvn clean test

To build this project use:
mvn clean package

To check code coverage use:
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent test org.jacoco:jacoco-maven-plugin:report
And open the index.html file inside ./target/site/jacoco

To start the service use:
java -jar calser-0.0.1-SNAPSHOT.jar

To visualize the Swagger EndPoint open inside the browser:
http://localhost:8765/swagger-ui.html

To execute calculations:
http://localhost:8765/calculator?firstValue=2&secondValue=2&operationType=add
http://localhost:8765/calculator?firstValue=4&secondValue=4&operationType=sub
http://localhost:8765/calculator?firstValue=8&secondValue=8&operationType=mul
http://localhost:8765/calculator?firstValue=5&secondValue=5&operationType=div


