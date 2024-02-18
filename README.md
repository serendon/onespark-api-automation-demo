# onespark-api-automation-demo

This project contains automated tests for the OneSpark API.

### Prerequisites
- Java 11 or higher
- Maven

### Plugins
- Cucumber for Java
- Gherkin

### Dependencies
- Rest Assured: A Java library for testing RESTful APIs.
- Cucumber JUnit: A testing framework that supports behavior-driven development (BDD).
- Cucumber Java: Cucumber implementation for Java.
- JSON: A simple Java library for JSON processing.
- Gson: A Java library for JSON serialization and deserialization.

### maven commands:

```bash
mvn clean test
mvn clean test -Dconfig.file=config-production.properties
mvn clean test -Dconfig.file=config-uat.properties
```

## Test runner class
File path: src/test/java/TestRunner/CucumberRunnerTests.java

## View Test Report
File path: target/cucumber.html

## Config File Reader
Java class ConfigFileReader is responsible for reading configuration properties from a properties file.
There's a static block that initializes the properties object. Inside the block it attempts to read a configuration file specified by the system property "config.file". If no system property is set, it defaults to "config-production.properties".

## CucumberRunnerTests Class
The CucumberRunnerTests class is used to configure and execute Cucumber tests using TestNG. It specifies the locations of feature files and step definitions, as well as the plugins to use for generating test reports. When executed, it runs the Cucumber scenarios defined in the feature files and produces test reports based on the specified plugins.

## Feature Files and Step Definitions
Feature files provide a human-readable description of the behavior of the application, while step definitions provide the executable implementation of that behavior. Together, they enable collaboration between technical and non-technical stakeholders and facilitate the automated testing of software applications based on user requirements.

## Reference links
https://qaautomation.expert/2023/10/20/rest-api-test-in-cucumber-bdd/
