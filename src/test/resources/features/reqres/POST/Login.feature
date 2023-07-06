Feature: Reqres login user
  @Tugas
  Scenario: Login user with valid user
    Given Successfully login with valid JSON
    When Send a post login successful
    Then Status code should be 200 OK

  @Tugas
  Scenario: Login user with invalid user
    Given Unsuccessfully login with invalid JSON
    When Send a post login unsuccessful
    Then Login status code should be 400 not found unsuccessfull