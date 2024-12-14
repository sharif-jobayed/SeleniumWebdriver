Feature: Search page

  Background:
    Given I'm on the "Search" page
    Then The "Search" page is open
    And The "Search" page is loaded

    Scenario: Search for the context
      When I type "Wasim Akram" in the "Search" field
      Then The "Results" dropdown list is displayed

      When I click the first result from the search dropdown
      Then The "Details" page opens up
      And The "Details" page is open
      And The "Details" page is loaded
