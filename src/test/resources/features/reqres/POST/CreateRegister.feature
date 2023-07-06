Feature: Reqres post create register

  @Tugas
  Scenario: Create a register post was successful with a valid JSON
    Given Successfully posted registration with valid JSON
    When Send a post indicating successful user register
    Then Status code should be 200 OK

  @Tugas
  Scenario: Create a register post was unsuccessful with a valid JSON
    Given Unsuccessfully posted registration with valid JSON
    When Send a post indicating unsuccessful user register
    Then Status code should be 400 Bad Request
