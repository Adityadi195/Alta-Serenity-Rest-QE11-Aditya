Feature: Reqres post create user

  @Tugas
  Scenario: Create new user was unsuccessful with empty name
    Given Create new user with empty name
    When Send a post indicating unsuccessful create new user
    Then Status code should be 400 bad request

  @Tugas
  Scenario: Create new user with empty job
    Given Post create user with empty job
    When Send a post indicating unsuccessful create new user
    Then Status code should be 400 bad request

  @Tugas
  Scenario: Create new User with empty body request
    Given Post create user with empty body request
    When Send a post indicating unsuccessful create new user
    Then Status code should be 400 bad request

  @Tugas
  Scenario: Create new User with invalid body request
    Given Post create user with invalid body request
    When Send a post indicating unsuccessful create new user
    Then Status code should be 400 bad request