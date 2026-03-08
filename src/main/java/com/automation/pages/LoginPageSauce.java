package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.automation.utils.WaitUtil;
import com.automation.config.ConfigReader;
public class LoginPageSauce {
    WebDriver driver;
    String sauceUrl;
    private WaitUtil waitUtil;
    private static final Logger log = LogManager.getLogger(LoginPageSauce.class);

    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//input[@id='login-button']");
    By  product = By.xpath("//span[contains(text(),'Products')]");

    public LoginPageSauce(WebDriver driver)
    {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver, 10);
        this.sauceUrl = ConfigReader.getSauceUrl();
    }

     public void enterSauceUsername(String user) {
        log.info("Entering username: " + user);
        waitUtil.waitForVisibility(username).sendKeys(user);
    }

    public void enterSaucePassword(String pass) {
        waitUtil.waitForVisibility(password).sendKeys(pass);
    }

    public void clickSauceLogin() {
        waitUtil.waitForClickable(loginBtn).click();
    log.info("Clicked login button");

    }

    public void goToLoginPage()
    {
        driver.get(sauceUrl);
        log.info("Navigated to SauceUrl");
    }

    public void verifyProductPage()
    {
        waitUtil.waitForText(product, "Products");
    }
}
