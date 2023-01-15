package phonebook.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static phonebook.pages.Constants.BASE_URL_LP;

/**
 * Class LoginPageSteps contains all steps page.
 */
public class LoginPageSteps extends BaseSteps {

    @Given("I am on Login page")
    public void iAmOnLoginPage() {
        open(BASE_URL_LP);
    }

    @When("I fill in login data")
    public void iFillInLoginData(DataTable dataTable) {
        List<List<String>> loginForms = dataTable.asLists(String.class);
        String email = loginForms.get(0).get(0);
        String password = loginForms.get(0).get(1);
        loginPage.fillInDataFields(email, password);
    }

    @When("I click Login button")
    public void iClickLoginButton() {
        contactsPage = loginPage.clickOnLoginBtnLP();
    }

    @When("I click on Register new Account")
    public void iClickSignUpButton() {
        registrationPage = loginPage.clickOnRegisterNewAccount();
    }

    @When("I fill in invalid login data")
    public void iFillInInvalidLoginData() {
        loginPage.fillInLoginInvalidDataFields();
    }

    @When("I fill invalid data")
    public void iFillInvalidData(DataTable dataTable) {
        List<List<String>> loginForms = dataTable.asLists(String.class);
        String email = loginForms.get(0).get(0);
        String password = loginForms.get(0).get(1);
        loginPage.fillInDataFields(email, password);
    }

    @When("I click on Email Field")
    public void iClickOnEmailField() {
        loginPage.clickOnEmailFieldLP();
    }

    @When("I click on Password Field")
    public void iClickOnPasswordField() {
        loginPage.clickOnPasswordFieldLP();
    }

    @When("I click on Already have an account?")
    public void iClickOnAlreadyHaveAnAccount() {
        loginPage = forgotPasswordPage.alreadyHaveAnAccountClick();
    }

    @Then("I see Please check your activation or Login + Password combination")
    public void iSeePleaseCheckYourActivationOrLoginPasswordCombination() {
        contactsPage = loginPage.clickOnLoginBtnLP();
        loginPage.iSeePleaseCheckYourActivationOrLoginPasswordCombinationMsg();
    }

    @Then("I see {} Message")
    public void iSeeErrorMessage(String msg) {
        loginPage.iSeeEmailMustBeAValidEmailAddressMsg(msg);
    }

    @Then("I see Message Email is required.")
    public void iSeeMessageEmailIsRequired() {
        loginPage.emailIsRequired();
    }

    @Then("I see Message Password is required.")
    public void iSeeMessagePasswordIsRequired() {
        loginPage.passwordIsRequired();
    }

    @Then("I see {} Messages")
    public void iSeeErrorPasswordMessageMessages(String msg) {
        loginPage.passwordMustBe(msg);
    }

    @Then("I see Login Page")
    public void iSeeLoginPage() {
        loginPage.iSeeLoginPage();
    }

}
