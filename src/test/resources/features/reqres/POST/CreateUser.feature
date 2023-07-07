Feature: API Automation Testing ALTA QE Batch 11

  @Latihan @CreateUser
  Scenario: Post create new user with valid JSON
    Given Post create user with valid json
    When Send request post create user
    Then Status code should be 201 created
    And Response body name was "Aditya Dwi Irawan" an job was "QA Engineer"