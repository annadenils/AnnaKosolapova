Feature: Main Page

  Scenario: Check Main Page
    Given Open website
    And Page title is "Home Page"
    When Perform login
    And Check login and user name
    When Open Different Element Page
    And Page title is "Different Element"
    And Select checkbox "Water"
    And Select checkbox "Wind"
    And Select radiobutton "Selen"
    And Select dropdown "Yellow"
    And Logs "Water: condition changed to true" is displayed
    And Logs "Wind: condition changed to true" is displayed
    And Logs "metal: value changed to Selen" is displayed
    And Logs "Colors: value changed to Yellow" is displayed