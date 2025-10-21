Feature: Login functionality

  @login @positive
  Scenario: Successful login with valid credentials
    Given user is opened login page
    When user enters valid username and password
    And user clicks the login button
    Then user should be redirected to the homepage

  @login @negative
   Scenario: Enter invalid name
     Given user is opened login page
     When user enters invalid username and password
     And user clicks the login button
     Then user see an error

  @login @positive
  Scenario: Successful logout from platform
    Given user is login to the platform
    When user click more menu button
    And user click logout item
    And user click Yes button
    Then user see login form

