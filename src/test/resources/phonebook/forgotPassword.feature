Feature: Forgot password page

  Background:
    Given I am on Login page
    When I click on Forgot password?

  @ForgotPassword1
  Scenario Outline: Forgot password?1 Invalid
    And I fill Email data
      | <email> |
    Then I see <Error Message> Error Message Email must be a valid email address.
    Examples:
      | email | Error Message                        |
      | 1     | Email must be a valid email address. |

  @ForgotPassword2
  Scenario Outline: Forgot password?2 Invalid
    And I fill Email data
      | <email> |
    Then I see <Error Message> Error Message Error! This user doesn't exist in our DB
    Examples:
      | email         | Error Message                            |
      | test@gmail.co | Error! This user doesn't exist in our DB |

  @ForgotPassword3
  Scenario Outline: Forgot password?3 Valid
    And I fill Email data
      | <email> |
    Then I see <Message> Password recovery instructions have been sent
    Examples:
      | email          | Message                                                          |
      | test@gmail.com | Password recovery instructions have been sent to test@gmail.com. |

  @ForgotPassword4
  Scenario: Forgot password?4
    And I click on Already have an account?
    Then I see Login Page
