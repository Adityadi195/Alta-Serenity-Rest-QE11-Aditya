Feature: Reqres get list user

  @Tugas
  Scenario Outline: Get list user with special character parameter
    Given Get list user with special character parameter "<char>"
    When Send request get list user char
    Then Status code should be 404 not found
    Examples:
      | char  |
      | !!@$# |
      | @##%* |