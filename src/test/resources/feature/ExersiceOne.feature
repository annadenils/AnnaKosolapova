Feature: Main Page

  Scenario: Check Main Page
    Given Open website
    And Page title is Home Page
    When Perform login
    And Check login and user name
    When Open Different Element Page
    And Select checkboxes Water and Wind
    And Select radiobutton Selen
    And Select dropdown Yellow
    And Logs are displayed