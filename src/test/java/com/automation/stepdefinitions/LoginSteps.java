package com.automation.stepdefinitions;

// import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.driverfactory.DriverFactory;
import com.automation.pages.LoginPage;
import com.automation.config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    ConfigReader config = new ConfigReader();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.getDriver();
        driver.get(config.getBaseUrl() + "/login");
        loginPage = new LoginPage(driver);

}
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();
    }
    @Then("user should see secure area message")
    public void user_should_see_secure_area_message() {
        String message = loginPage.getSuccessMessage();
        System.out.println("Login message: " + message);

    }

}
