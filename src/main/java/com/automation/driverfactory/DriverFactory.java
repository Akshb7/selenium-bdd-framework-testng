package com.automation.driverfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(){
        WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
options.addArguments("--disable-save-password-bubble"); // Disable password prompt
options.addArguments("--disable-credential-saving");   // Prevent Google prompts
options.addArguments("--start-maximized");

// Optional: Use a fresh profile folder
// options.addArguments("user-data-dir=/tmp/temp-profile"); 
        driver.set(new ChromeDriver(options));
       

        return getDriver();
    }
    public static WebDriver getDriver() {
        return driver.get();
    }
}
