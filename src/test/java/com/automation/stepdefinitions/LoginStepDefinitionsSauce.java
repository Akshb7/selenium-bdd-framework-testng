package com.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.automation.driverfactory.DriverFactory;
import com.automation.pages.LoginPageSauce;
import com.automation.config.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDefinitionsSauce {

    WebDriver driver;
    LoginPageSauce loginPageSauce;

    public LoginStepDefinitionsSauce() {
        driver = DriverFactory.getDriver();       // ensures driver is never null
        loginPageSauce = new LoginPageSauce(driver);
    }

    @Given("user is on SauceDemo login page")
    public void user_is_on_saucedemo_login_page() {
        loginPageSauce.goToLoginPage();           // driver is already initialized
    }

    @When("user enters SauceDemo username and password")
    public void user_enters_valid_username_and_password() {
        loginPageSauce.enterSauceUsername(ConfigReader.getUsername());
        loginPageSauce.enterSaucePassword(ConfigReader.getPassword());
    }

    @When("clicks login")
    public void clicks_login() {
        loginPageSauce.clickSauceLogin();
    }

    @Then("user should see home page")
    public void user_should_see_home_page() {
        loginPageSauce.verifyProductPage();
        System.out.println("Verified Home Page");
    }
}