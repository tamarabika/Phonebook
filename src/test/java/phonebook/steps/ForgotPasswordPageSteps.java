package phonebook.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

/**
 * Class ForgotPasswordPageSteps contains all steps page.
 */
public class ForgotPasswordPageSteps extends BaseSteps {

    @When("I click on Forgot password?")
    public void iClickOnForgotPassword() {
        forgotPasswordPage = loginPage.clickOnForgotPassword();
    }

    @When("I click Send Btn")
    public void iClickSendBtn() {
        forgotPasswordPage.clickOnSendBtnFPP();
    }

    @When("I fill Email data")
    public void iFillInvalidEmail(DataTable dataTable) {
        List<List<String>> forgotPasswordForms = dataTable.asLists(String.class);
        String email = forgotPasswordForms.get(0).get(0);
        forgotPasswordPage.fillEmailData(email);
    }

    @Then("I see Forgot password page")
    public void iSeeForgotPasswordPagePage() {
        forgotPasswordPage.iSeePasswordRecoveryText();
    }

    @Then("I see {} Error Message Email must be a valid email address.")
    public void iSeeErrorEmailMessage1(String msg) {
        forgotPasswordPage.clickOnSendBtnFPP();
        forgotPasswordPage.iSeeErrorMsg1(msg);
    }

    @Then("I see {} Error Message Error! This user doesn't exist in our DB")
    public void iSeeErrorEmailMessage2(String msg) {
        forgotPasswordPage.clickOnSendBtnFPP();
        forgotPasswordPage.iSeeErrorMsg2(msg);
    }

    @Then("I see {} Password recovery instructions have been sent")
    public void iSeeErrorMessagePasswordRecoveryInstructionsHaveBeenSent(String msg) {
        forgotPasswordPage.clickOnSendBtnFPP();
        forgotPasswordPage.iSeeEmailMsg(msg);
    }
}


