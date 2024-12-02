

Feature: Wikipedia Functionality Testing

  Background:
    Given the user is on the Main page
    Then the user inputs "Albert Einstein" in the search field

  Scenario: Download PDF from Albert Einstein Article
    Then the user clicks on the search submit button
    And the user clicks the Tool menu button on the Article page
    And the user clicks the Download as PDF button on the Article page
    Then the file with the provided name on the Download as PDF page should be downloaded

  Scenario: View Page Information for Albert Einstein Article
    Then the user clicks on the search submit button
    And the user clicks the Tool menu button on the Article page
    And the user clicks the Page information button on the Article page
    Then the Information page for the "Albert Einstein" article should be displayed

  Scenario: Search Albert Einstein in Spanish Language
    When the user changes the search language to "Español"
    Then the user clicks on the search submit button
    Then the Article page for "Albert Einstein" in Spanish should be open
