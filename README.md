# Selenium BDD Framework with TestNG

[![GitHub issues](https://img.shields.io/github/issues/Akshb7/selenium-bdd-framework-testng)](https://github.com/Akshb7/selenium-bdd-framework-testng/issues)  
[![GitHub stars](https://img.shields.io/github/stars/Akshb7/selenium-bdd-framework-testng)](https://github.com/Akshb7/selenium-bdd-framework-testng/stargazers)  

## Overview
This is a **Selenium BDD automation framework** using **Java, TestNG, and Cucumber**.  
It is designed to provide a **maintainable, reusable, and scalable structure** for web automation testing.

---

## Features
- **BDD with Cucumber**: Write readable and maintainable test scenarios.
- **TestNG Integration**: Parallel test execution and detailed reporting.
- **Page Object Model (POM)**: Clean separation of page interactions.
- **Logging & Reporting**:
  - Log4j for logging
  - ExtentReports for detailed HTML test reports
- **Thread-safe WebDriver** for parallel execution.
- **Cross-browser support** (currently Chrome, can be extended).
- **Automatic screenshot capture** on test success/failure.

---

## Project Structure

selenium-bdd-framework-testng/
│
├── src/main/java/com/automation/driverfactory # WebDriver setup
├── src/main/java/com/automation/pages # Page Object Models
├── src/main/java/com/automation/utils # Utility classes (Waits, Screenshot, etc.)
├── src/test/java/com/automation/stepdefinitions # Step Definitions for Cucumber
├── src/test/java/com/automation/runners # TestNG / Cucumber runners
├── src/test/resources/features # Cucumber feature files
├── pom.xml # Maven dependencies
└── README.md # Project documentation


---

## Setup & Installation

1. **Clone the repository**
```bash
git clone https://github.com/Akshb7/selenium-bdd-framework-testng.git
cd selenium-bdd-framework-testng
Install dependencies with Maven
mvn clean install
Run tests using TestNG suite
mvn clean test -DsuiteXmlFile=testng.xml

Example Test Scenarios:
Login functionality
Form submission
Navigation verification
SauceDemo login automation

How to Extend:
Add new Page Objects in pages folder.
Add corresponding Step Definitions in stepdefinitions.
Extend DriverFactory for other browsers (Firefox, Edge).
Integrate with Jenkins for CI/CD pipeline automation.

Author
Akshata Bhat
Passionate about Test Automation, BDD, and QA Engineering
