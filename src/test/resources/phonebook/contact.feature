Feature: Contact page

  Background:
    Given I am Logged in

  @NewContact
  Scenario: Pop up Add new contact
    When I am choosing language
    And I click Add new contact
    Then I see pop up Add new contact

  @CheckLanguage
  Scenario Outline: I check language with text
    Then I see <text> language
    Examples:
      | text                    |
      | Add new contact         |
      | Neue Kontakt hinzufügen |
      | Додати новий контакт    |
      | Добавить новый контакт  |

  @NewContactFaker
  Scenario: Add new contact with Faker
    When I click Add new contact
    And I fill contacts data
    And I click Save Button
    Then I see Edit Button

  @EditContact
  Scenario: Edit contact
    When I add New Contact
    And I change contacts data
      | test |
    And I click Save Edit Button
   Then I see test in First name Field

  @AddPhone
  Scenario: Add phone number
    When I add New Contact
    Then I add new Phone number in Phone book
