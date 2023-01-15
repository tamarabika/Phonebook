Feature: Login page

  Background:
    Given I am on Login page

  @Login1
  Scenario: Valid login
    When I fill in login data
      | test@gmail.com | test@gmail.com |
    And I click Login button
    Then I see Contacts page

  @Login2
  Scenario: Invalid login with Faker
    When I fill in invalid login data
    And I click Login button
    Then I see Please check your activation or Login + Password combination

  @Login3
  Scenario Outline: Invalid login1
    When I fill invalid data
      | <email> | <password> |
    Then I see <Error Email Message> Message
    Examples:
      | email | password | Error Email Message                  |
      | 1     |          | Email must be a valid email address. |

  @Login4
  Scenario: Invalid login2
    When I click on Email Field
    And I click on Password Field
    Then I see Message Email is required.

  @Login5
  Scenario: Invalid login3
    When I click on Password Field
    And I click on Email Field
    Then I see Message Password is required.

  @Login6
  Scenario: Invalid login4
    When I click on Email Field
    And I click on Password Field
    And I click on Email Field
    Then I see Message Email is required.
    And I see Message Password is required.

  @Login7
  Scenario Outline: Invalid login5
    When I fill invalid data
      | <email> | <password> |
    Then I see <Error Password Message> Messages
    Examples:
      | email | password                    | Error Password Message                         |
      |       | 1                           | Password must be at least 8 characters.        |
      |       | 111111111111111111111111111 | Password must be no longer than 20 characters. |

  @Login8
  Scenario: Forgot password?
    When I click on Forgot password?
    Then I see Forgot password page
