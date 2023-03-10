Feature: Contact page

  Background:
    Given I am Logged in

  @Contact1
  Scenario: Pop up Add new contact
    When I am choosing language
    And I click Add new contact
    Then I see pop up Add new contact

  @Contact2
  Scenario Outline: I check language with text
    Then I see <text> language
    Examples:
      | text                    |
      | Add new contact         |
      | Neue Kontakt hinzufügen |
      | Додати новий контакт    |
      | Добавить новый контакт  |

  @Contact3
  Scenario: Add new contact with Faker
    When I click Add new contact
    And I fill contacts data
    And I click Save Button
    Then I see Edit Button

  @Contact4
  Scenario: Edit contact
    When I add New Contact
    And I change contacts data
      | test |
    And I click Save Edit Button
   Then I see test in First name Field

  @Contact5
  Scenario: Add phone number
    When I add New Contact
    Then I add new Phone number in Phone book
#    And I click Add new contact
#    And I fill contacts data
#    And I click Save Button
#    And  I click Phones Tab
#    And I click Add phone number Button
#    And I Add new phone number
#    And I click Save phone Button
#    Then I see added phones number
