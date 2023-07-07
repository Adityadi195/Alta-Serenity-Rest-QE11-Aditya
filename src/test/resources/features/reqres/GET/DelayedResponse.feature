Feature: Reqres get delayed
  @Tugas
  Scenario Outline: Get delayed response with valid parameter page
    Given Get delayed response with parameter <page>
    When Send get delayed response request
    Then Status code should be 200 OK
    And Response body page should be <page>
    Examples:
      | page |
      | 1    |