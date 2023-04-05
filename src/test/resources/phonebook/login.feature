Feature: Login page

  Background:
    Given I am on Login page

  @ValidLogin
  Scenario: Valid login
    When I fill in login data
      | test@gmail.com | test@gmail.com |
    Then I see Contacts page

  @InvalidLoginWithFaker
  Scenario: Invalid login with Faker
    When I fill in invalid login data
    Then I see Please check your activation or Login + Password combination

  @EmailMustBeAValid
  Scenario Outline: Email must be a valid
    When I fill invalid data
      | <email> | <password> |
    Then I see <Error Email Message> Message
    Examples:
      | email | password | Error Email Message                  |
      | 1     |          | Email must be a valid email address. |

  @EmailIsRequired
  Scenario: Email is required
    When I click on Email Field
    And I click on Password Field
    Then I see Message Email is required.

  @PasswordIsRequired
  Scenario: Password is required
    When I click on Password Field
    And I click on Email Field
    Then I see Message Password is required.

  @EmailAndPasswordAreRequired
  Scenario: Email and Password are required
    When I click on Email Field
    And I click on Password Field
    And I click on Email Field
    Then I see Message Email is required.
    And I see Message Password is required.

  @PasswordCharacters
  Scenario Outline: Password characters
    When I fill invalid data
      | <email> | <password> |
    Then I see <Error Password Message> Messages
    Examples:
      | email | password                    | Error Password Message                         |
      |       | 1                           | Password must be at least 8 characters.        |
      |       | 111111111111111111111111111 | Password must be no longer than 20 characters. |

  @ForgotPassword
  Scenario: Forgot password?
    When I click on Forgot password?
    Then I see Forgot password page
