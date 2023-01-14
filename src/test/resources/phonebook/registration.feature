Feature: Registration page

  @Registration1
  Scenario: Invalid registration with Faker Email and Datatable Password
    Given I am on Login page
    And I click on Register new Account
    When I fill in registration data
      | email | password/12345 | password/12345 |
    And I click Sign up button
    Then I can see no Error Message
