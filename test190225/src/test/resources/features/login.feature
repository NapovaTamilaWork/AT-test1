Feature: Login functionality

  Scenario: : Successful login with valid credentials
    Given user is opened login page
    When user enters valid username and password
    And user clicks the login button
    Then user should be redirected to the homepage