package phonebook.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static phonebook.pages.Constants.BASE_URL_LP;

/**
 * Class ContactPageSteps contains all steps page.
 */
public class ContactsPageSteps extends BaseSteps {

    @When("I click Add new contact")
    public void iClickAddNewContact() {
        contactsPage.iClickAddNewContactCP();
    }

    @When("I am choosing language")
    public void iAmChoosingLanguage() {
        contactsPage.imChoosingLanguageCP();
    }

    @When("I fill contacts data")
    public void iFillContactsData() {
        contactsPage.fillContactsData();
    }

    @When("I click Save Button")
    public void iClickSaveButton() {
        contactsPage.saveBtnClick();
    }

    @Then("I see pop up Add new contact")
    public void iSeePopUpAddContact() {
        contactsPage.iSeePopUpCP();
    }

    @Then("I see {} language")
    public void iSeeTextLanguage(String text) {
        contactsPage.checkLanguage(text);
    }

    @Then("I see Contacts page")
    public void iSeeContactsPage() {
        contactsPage.iSeeTextCP();
    }

    @Then("I see Edit Button")
    public void iSeeContactInfo() {
        contactsPage.iSeeEditBtn();
    }


    @When("I click Edit Button")
    public void iClickOnEditButton() {
        contactsPage.editBtnClick();
    }

    @When("I change contacts data")
    public void iChangeContactsData(DataTable dataTable) {
        List<List<String>> editForms = dataTable.asLists(String.class);
        String fName = editForms.get(0).get(0);
        contactsPage.contactDataChange(fName);
    }

    @When("I click Save Edit Button")
    public void iClickSaveEditButton() {
        contactsPage.saveEditBtnClick();
    }

    @Then("I see test in First name Field")
    public void iSeeTestInFirstNameField() {
        contactsPage.contactChanged();
    }
}


