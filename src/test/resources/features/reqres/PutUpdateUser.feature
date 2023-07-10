Feature: Reqres put update user

  @Tugas
  Scenario Outline: Put update user with invalid key on body request
    Given Put update user with invalid key body request <body>
    When Send request put update user
    Then Status code should be 404 not found
    Examples:
      | body |
      | 1    |
      | 2    |

