package phonebook.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

/**
 * Class RegistrationPageSteps contains all steps page.
 */
public class RegistrationPageSteps extends BaseSteps {

    @When("I fill in registration data")
  public void iFillRegistrationDate(DataTable dataTable) {
      List<List<String>> registrationForms = dataTable.asLists(String.class);
      String password = registrationForms.get(0).get(1);
      String confirmPassword = registrationForms.get(0).get(2);
      registrationPage.fillInRegistrationDataFields(password,confirmPassword);
  }
    @When("I click Sign up button")
    public void iClickSignUpButton() {
        contactsPage = registrationPage.clickOnSignUpBtn();
    }

    @Then("I can see no Error Message")
    public void iCanSeeNoErrorMessage() {
        contactsPage = registrationPage.clickOnSignUpBtn();
      registrationPage.iSeeNoErrorMsg();
    }
}
