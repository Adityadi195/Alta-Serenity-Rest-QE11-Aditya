Feature: Reqres get single user

  @Tugas @SingleUser
  Scenario Outline: Get a single user with a valid parameter id
    Given Get a single user with a valid ID <id>
    When Send a get request for a single user
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @SingleUser
  Scenario Outline: Get a single user with an invalid parameter id
    Given Get a single user using an invalid id <id>
    When Send a request to get a single user
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 111 |
      | 211 |
      | 555 |

  @Tugas @SingleUserNotFound
  Scenario Outline: Get single user not found with valid parameter id
    Given  Get single user with id was not found <id>
    When Send get single user not found request
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 23 |
      | 55 |
      | 33 |