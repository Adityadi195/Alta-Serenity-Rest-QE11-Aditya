Feature: Reqres get single user

  @Tugas
  Scenario Outline: Get a single user with a valid parameter id
    Given Get a single user with a valid ID <id>
    When Send a get request for a single user
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario Outline: Get a single user with an invalid parameter id
    Given Get a single user using an invalid id <id>
    When Send a request to get a single user
    Then Status code should be 404 not found
    Examples:
      | id  |
      | 111 |
      | 222 |

  @Tugas
  Scenario Outline: Get Single User with Special Character
    Given Get single user with special character <character>
    When Send request get single user special character
    Then Status code should be 404 not found
    Examples:
      |character|
      |@@@      |
      |$#%@     |