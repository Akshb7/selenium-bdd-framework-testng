package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Path for the HTML report
            String reportPath = System.getProperty("user.dir") + "/target/ExtentReports/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Selenium Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Optional: add system info
            extent.setSystemInfo("Tester", "Akshata Bhat");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}