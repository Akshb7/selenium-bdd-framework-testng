package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/SauceDemoLogin.feature",
        glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
        plugin = { 
            "pretty", 
            "html:target/cucumber-reports/sauce-login.html",
            "json:target/cucumber-reports/sauce-login.json"
        },
        monochrome = true
)
public class TestRunnerSauce extends AbstractTestNGCucumberTests {
}