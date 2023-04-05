Feature: Forgot password page

  Background:
    Given I am on Login page
    When I click on Forgot password?

  @EmailMustBeAValid
  Scenario Outline: Email must be a valid
    And I fill Email data
      | <email> |
    Then I see <Error Message> Error Message Email must be a valid email address.
    Examples:
      | email | Error Message                        |
      | 1     | Email must be a valid email address. |

  @UserDoesNotExist
  Scenario Outline: This user doesn't exist
    And I fill Email data
      | <email> |
    Then I see <Error Message> Error Message Error! This user doesn't exist in our DB
    Examples:
      | email         | Error Message                            |
      | test@gmail.co | Error! This user doesn't exist in our DB |

  @InstructionsHaveBeenSent
  Scenario Outline: Instructions have been sent
    And I fill Email data
      | <email> |
    Then I see <Message> Password recovery instructions have been sent
    Examples:
      | email          | Message                                                          |
      | test@gmail.com | Password recovery instructions have been sent to test@gmail.com. |

  @AlreadyHaveAnAccount?
  Scenario: Already have an account?
    And I click on Already have an account?
    Then I see Login Page
