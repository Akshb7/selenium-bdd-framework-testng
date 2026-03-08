package com.automation.hooks;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automation.driverfactory.DriverFactory;
import com.automation.utils.ScreenshotUtil;
import com.automation.utils.ExtentManager;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class);

    // ExtentReports objects
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest test;

    // This runs before each scenario
    @Before
    public void setUp(Scenario scenario) {
        // Initialize driver
        DriverFactory.initDriver();
        log.info("Browser initialized");

        // Create a test in ExtentReports for this scenario
        test = extent.createTest(scenario.getName());
    }

    // This runs after each scenario
    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        // Capture screenshot for both success and failure
        String screenshotPath = ScreenshotUtil.captureScreenshot(
                driver,
                scenario.getName() + (scenario.isFailed() ? "_Failed" : "_Success")
        );

        // Log in ExtentReports and Log4j
        if (scenario.isFailed()) {
            test.fail("Scenario FAILED");
            test.addScreenCaptureFromPath(screenshotPath);
            log.error("Scenario FAILED: " + scenario.getName());
        } else {
            test.pass("Scenario PASSED");
            test.addScreenCaptureFromPath(screenshotPath);
            log.info("Scenario PASSED: " + scenario.getName());
        }

        // Close browser
        driver.quit();
        log.info("Browser closed");

        // Write everything to report
        extent.flush();
    }
}