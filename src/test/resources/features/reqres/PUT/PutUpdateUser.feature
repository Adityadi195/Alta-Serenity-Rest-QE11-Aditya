Feature: API Automation Testing ALTA QE Batch 11

  @Latihan
  Scenario Outline: Put update user with valid parameter id and JSON
    Given Put update user with valid id <id> and json
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name was "Aditya Dwi Edit" and job was "QA Edit"
    Examples:
      |id|
      |1 |
      |2 |