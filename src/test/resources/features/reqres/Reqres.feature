Feature: API Automation Testing ALTA QE Batch 11

  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list user
    Then Status code should be 200 OK
    And Response body page value should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan
  Scenario: Create new user was successful with complete request
    Given Create new user with complete body request
    When Send a post indicating successful create new user
    Then Status code should be 201 created
    And Response body name was "Aditya Dwi Irawan" an job was "QA Engineer"

  @Latihan
  Scenario Outline: Put update user with valid parameter id and JSON
    Given Put update user with valid id <id> and json
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name was "Aditya Dwi Edit" and job was "QA Edit"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Latihan
  Scenario Outline: Delete user with valid id parameter
    Given Delete user with valid id parameter <id>
    When Send request delete user
    Then Status code should be 204 no content
    Examples:
      | id |
      | 1  |
      | 2  |
