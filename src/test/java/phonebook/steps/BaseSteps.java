package phonebook.steps;

import phonebook.pages.ContactsPage;
import phonebook.pages.ForgotPasswordPage;
import phonebook.pages.LoginPage;
import phonebook.pages.RegistrationPage;

/**
 * Class BaseSteps contains all base steps.
 */
public class BaseSteps {

    public LoginPage loginPage = new LoginPage();
    public static ContactsPage contactsPage;
    public static ForgotPasswordPage forgotPasswordPage;
    public static RegistrationPage registrationPage;
}
