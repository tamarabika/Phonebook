Feature: Registration page

  @Registration
  Scenario: Invalid registration with Faker Email and Datatable Password
    Given I am on Login page
    And I click on Register new Account
    When I fill in registration data
      | email | password/12345 | password/12345 |
    Then I can see no Error Message
