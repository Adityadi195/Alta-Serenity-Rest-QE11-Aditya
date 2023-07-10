Feature: Reqres login user

  @Tugas @LoginSuccessful
  Scenario: Login user with valid user
    Given Successfully login with valid JSON
    When Send request login
    Then Status code should be 200 OK
    And Login user successful json schema

  @Tugas @LoginUnsuccessful
  Scenario: Login user with invalid user
    Given Unsuccessfully login with invalid JSON
    When Send request login
    Then Status code should be 400 bad request
    And Post login unsuccessful json schema

  @Tugas
  Scenario: Login unsuccessful with empty email value
    Given Login user with empty email on body request
    When Send request login
    Then Status code should be 400 bad request
    And Response body contain "Missing email or username"
    And Post login unsuccessful json schema

  @Tugas
  Scenario: Login unsuccessful with empty password value
    Given Login user with empty password on body request
    When Send request login
    Then Status code should be 400 bad request
    And Response body will be contains "Missing password"
    And Post login unsuccessful json schema

  @Tugas
  Scenario: Login unsuccessful with empty email and username value
    Given Login user unsuccessful with empty value on body request
    When Send request login
    Then Status code should be 400 bad request
    And Response body will containing Missing email or username
    And Post login unsuccessful json schema

  @Tugas
  Scenario: Login unsuccessful with invalid email format
    Given Login user unsuccessful with invalid email format
    When Send request login
    Then Status code should be 400 bad request
    And Response body will containing user not found
    And Post login unsuccessful json schema