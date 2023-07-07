Feature: API Automation Testing ALTA QE Batch 11

  @Latihan @GetListUser
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list user
    Then Status code should be 200 OK
    And Response body page value should be <page>
#    tambahin untuk page, per_page_total
    Examples:
      | page |
      | 1    |
      | 2    |

    @Tugas @GetList<Resource>