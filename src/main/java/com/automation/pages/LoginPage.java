package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.automation.utils.WaitUtil;

public class LoginPage {
    WebDriver driver;
    private WaitUtil waitUtil;
    private static final Logger log = LogManager.getLogger(LoginPage.class);


    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By successMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver, 10); // 10-second wait
    }

    public void enterUsername(String user) {
        log.info("Entering username: " + username);
        waitUtil.waitForVisibility(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        waitUtil.waitForVisibility(password).sendKeys(pass);
    }

    public void clickLogin() {
        waitUtil.waitForClickable(loginButton).click();
    log.info("Clicked login button");

    }

    public String getSuccessMessage() {
        String msg = waitUtil.waitForVisibility(successMessage).getText();
    log.info("Success message displayed: " + msg);
    return msg;

    }


}
