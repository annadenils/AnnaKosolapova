Feature: Main Page

  Scenario: Check Main Page
    Given Open website
    Then Page title is "Home Page"
    When Perform login
    Then Check login and user name
    When Open Different Element Page
    Then Page title is "Different Elements"
    Then Select checkbox "Water"
    And checkbox "Water" is selected
    Then Select checkbox "Wind"
    And checkbox "Wind" is selected
    Then Select radiobutton "Selen"
    And radiobutton "Selen" is selected
    Then Select dropdown "Yellow"
    And dropdown "Yellow" is selected
    Then Logs "Water: condition changed to true" is displayed
    Then Logs "Wind: condition changed to true" is displayed
    Then Logs "metal: value changed to Selen" is displayed
    Then Logs "Colors: value changed to Yellow" is displayed