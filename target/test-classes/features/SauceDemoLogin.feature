Feature: SauceDemo Login

  Scenario: Login with standard_user
    Given user is on SauceDemo login page
    When user enters SauceDemo username and password
    And clicks login
    Then user should see home page