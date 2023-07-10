Feature: Reqres delete user

  @Tugas
  Scenario Outline: Delete User with character parameter
    Given Delete user with special character parameter <character>
    When Send request delete user with char
    Then Status code should be 404 not found
    Examples:
      | character |
      | @#$$      |
      | #$%^      |