package com.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    /**
     * Captures a screenshot of the current browser window
     * @param driver - WebDriver instance
     * @param screenshotName - desired name of the screenshot file
     * @return path of the saved screenshot
     */
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        // Create timestamp for uniqueness
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Directory to save screenshots
        String screenshotDir = System.getProperty("user.dir") + "/target/screenshots/";
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Path for the screenshot file
        String path = screenshotDir + screenshotName + "_" + timestamp + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}