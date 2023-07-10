Feature: Reqres get delayed response

  @Tugas
  Scenario Outline: Get delayed response with valid parameter page
    Given Get delayed response with parameter <page>
    When Send get delayed response request
    Then Status code should be 200 OK
    And Response body page should be <page>
    Examples:
      | page |
      | 1    |

  @Tugas
  Scenario Outline: Get delayed response with invalid parameter page
    Given Get delayed responses with special character parameter <pages>
    When Send get delayed responses request
    Then Status code should be 404 not found
    Examples:
      | pages  |
      | !@#%   |
      | $%&%$  |