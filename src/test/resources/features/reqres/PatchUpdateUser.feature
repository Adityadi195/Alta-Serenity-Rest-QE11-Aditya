Feature: Reqres patch update user

  @Tugas
  Scenario: Patch user data with valid body request
    Given Patch user data json
    When Send request patch user data
    Then Status code should be 200 OK
    And response body will contain Aditya and QE Manager
    And Patch updated successful json schema

  @Tugas
  Scenario: Patch User Data with empty name
    Given Patch user data with empty name on body request
    When Send request patch user update data
    Then Status code should be 400 bad request

  @Tugas
  Scenario: Patch User Data with empty job value
    Given Patch user data with empty job on body request
    When Send request patch user update data
    Then Status code should be 400 bad request

  @Tugas
  Scenario: Patch User Data with empty name and job value
    Given Patch user data with empty value on body request
    When Send request patch user update data
    Then Status code should be 400 bad request
