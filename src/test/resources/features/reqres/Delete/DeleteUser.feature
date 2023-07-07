Feature: API Automation Testing ALTA QE Batch 11

  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 no content
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |