Feature: Check checkbox vip for Sergey Ivan

Scenario: Check checkbox vip for Sergey Ivan
  Given Open website
  And Page title is "Home Page"
  When Perform login
  And Check login and user name
  When I click on Service button in Header
  And I click on User Table button in Service dropdown
  When I select vip checkbox for "Sergey Ivan"
  Then Logs "Vip: condition changed to true" is displayed
