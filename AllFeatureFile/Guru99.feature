Feature: Test Guru99 Application

  Scenario: validate Register page functionality
    Given user is on register page
    When user enter firstname,lastname,phone and email

  Scenario Outline: validate mailing information
    When user enter "<address>", "<city>", "<state>", "<postalcode>" and "<country>"

    Examples: 
      | address | city     | state | postalcode | country |
      | Pune    | Baramati | MH    |     413456 | INDIA   |

  Scenario: validate user info
    When user enter username, password, confirmpassword and click on submit button
      | ns123 | nsk@3533 | nsk@3533 |
