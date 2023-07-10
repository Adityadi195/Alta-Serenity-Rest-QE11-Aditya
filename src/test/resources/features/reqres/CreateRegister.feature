Feature: Reqres post create register

  @Tugas
  Scenario: Create successful register with valid request
    Given Create registration with complete body request
    When Send a post indicating successful user register
    Then Status code should be 200 OK
    And Post register successful json schema

  @Tugas
  Scenario: Create unsuccessful register with valid request
    Given Create registration with incomplete body request
    When Send a post indicating unsuccessful user register
    Then Status code should be 400 bad request
    And Post register unsuccessful json schema

  @Tugas
  Scenario: Create register was unsuccessful with empty email
    Given Create register user with empty email value
    When Send a post indicating unsuccessful user register
    Then Status code should be 400 bad request
    And Response body will be contain "Missing email or username"
    And Post register unsuccessful json schema

  @Tugas
  Scenario: Create register was unsuccessful with empty password
    Given Create register user with empty password
    When Send a post indicating unsuccessful user register
    Then Status code should be 400 bad request
    And Response body contain "Missing password"
    And Post register unsuccessful json schema

  @Tugas
  Scenario: Create register user unsuccessful with empty value
    Given Create register user unsuccessful empty value
    When Send a post indicating unsuccessful user register
    Then Status code should be 400 bad request
    And Response body will containing Missing email or username
    And Post register unsuccessful json schema