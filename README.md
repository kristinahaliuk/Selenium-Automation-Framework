# Demo Selenium-Automation-Framework
<hr/>

This project is an example of UI automated functional test for WebstaurantStore Web Application based on Java programming language.
JUnit is used in combination with Cucumber that makes the framework BDD. 
The framework is designed in the way that it supports Parallel execution by implementing ThreadLocal.
Test scenarios are described in the feature files located in resources/features.

### Technologies used:
1. Java
2. JUnit
3. Selenium
4. Cucumber
5. Maven
6. WebDriver Manager

### Design Patterns:
1. Page Object Model
2. Singleton 
3. Page Factory

### Report:
Used Selenium 4 new HTML report

## Running Tests
    mvn test
    mvn test -Dbrowser="browserType"

## Supported Browsers
1. Chrome
2. Firefox
3. Edge
4. Safari


