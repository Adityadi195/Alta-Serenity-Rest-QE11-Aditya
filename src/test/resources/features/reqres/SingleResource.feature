Feature: Reqres get single resource

  @Tugas
  Scenario Outline: Get a single resource with a valid parameter id
    Given Get single resource with valid id <id>
    When Send request for a single resource
    Then Should return status code 200 OK
    And Response body id should be <id>
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario Outline: Get a single resource with a invalid parameter id
    Given Get single resource with invalid id <id>
    When Send request get single resource
    Then Status code should be 404 not found
    Examples:
      | id |
      | 77 |
      | 88 |

  @Tugas
  Scenario Outline: Get single resource not found with invalid Id
    Given Get single resource with invalid id <id>
    When Send request get single resource
    Then Status code should be 404 not found
    Examples:
      |id|
      |13|
      |14|

  @Tugas
  Scenario Outline: Get single resource not found with special character
    Given Get single with special character <character>
    When Send request get single resource
    Then Status code should be 404 not found
    Examples:
      | character |
      | @^&_&     |
      | $$*()     |