Feature: Reqres login user

  @Tugas @LoginSuccessful
  Scenario: Login user with valid user
    Given Successfully login with valid JSON
    When Send a post login successful
    Then Status code should be 200 OK

  @Tugas @LoginUnsuccessful
  Scenario: Login user with invalid user
    Given Unsuccessfully login with invalid JSON
    When Send a post login unsuccessful
    Then Status code should be 400 Bad Request
