Feature: Balance

  @Hide_balance
  Scenario: User can successfully hide balance
    Given user is login to the platform
    When user is pay attention to the eye button
    Then user see balance state "show"
    And user click on eye button
    And user is pay attention to the eye button
    Then user see balance state "hide"
    Then user see hide balance