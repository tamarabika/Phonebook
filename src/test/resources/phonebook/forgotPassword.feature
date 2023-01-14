Feature: Forgot password page

  @ForgotPassword1
  Scenario Outline: Forgot password?1 Invalid
    Given I am on Login page
    When I click on Forgot password?
    And I fill Email data
      | <email> |
    And I click Send Btn
    Then I see <Error Message> Error Message Email must be a valid email address.
    Examples:
      | email | Error Message                        |
      | 1     | Email must be a valid email address. |

  @ForgotPassword2
  Scenario Outline: Forgot password?2 Invalid
    Given I am on Login page
    When I click on Forgot password?
    And I fill Email data
      | <email> |
    And I click Send Btn
    Then I see <Error Message> Error Message Error! This user doesn't exist in our DB
    Examples:
      | email         | Error Message                            |
      | test@gmail.co | Error! This user doesn't exist in our DB |

  @ForgotPassword3
  Scenario Outline: Forgot password?3 Valid
    Given I am on Login page
    When I click on Forgot password?
    And I fill Email data
      | <email> |
    And I click Send Btn
    Then I see <Message> Password recovery instructions have been sent
    Examples:
      | email          | Message                                                          |
      | test@gmail.com | Password recovery instructions have been sent to test@gmail.com. |

  @ForgotPassword4
  Scenario: Forgot password?4
    Given I am on Login page
    When I click on Forgot password?
    And I click on Already have an account?
    Then I see Login Page
