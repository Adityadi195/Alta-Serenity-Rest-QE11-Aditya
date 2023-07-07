Feature: Reqres get single resource

  @Tugas @Single<Resource>
  Scenario Outline: Get a single resource with a valid parameter id
    Given Get single resource with valid id <id>
    When Send request for a single resource
    Then Should return status code 200 OK
    And Response body id should be <id>
    Examples:
      | id |
      | 2  |

  @Tugas @GetSingle<Resource>NotFound
  Scenario Outline: Get a single resource with a invalid parameter id
    Given Get single resource with invalid id <id>
    When Send request get single resource
    Then Should return status code 404 Not Found
    Examples:
      | id |
      | 99 |